package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.VariacaoProdutoRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.dto.response.VariacaoProdutoResponse;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.entity.Variacao;
import Gerenciamento.NilvanApp.repository.ProdutoRepository;
import Gerenciamento.NilvanApp.repository.VariacaoProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VariacaoProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    private  final VariacaoProdutoRepository variacaoProdutoRepository;

    private final ProdutoRepository produtoRepository;

    public VariacaoProdutoService(VariacaoProdutoRepository variacaoProdutoRepository , ProdutoRepository produtoRepository) {

        this.variacaoProdutoRepository = variacaoProdutoRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<VariacaoProdutoResponse> listarVariacoes() {
        List<Variacao> variacaos= variacaoProdutoRepository.findAll();
        List<VariacaoProdutoResponse> responses = variacaos.stream()
                .map(variacao -> modelMapper.map(variacao, VariacaoProdutoResponse.class))
                .collect(Collectors.toList());
        return responses;
    }


    public VariacaoProdutoResponse criarVariacao(VariacaoProdutoRequest variacaoProdutoRequest) {
        Variacao variacao = new Variacao();
        variacao.setNome(variacaoProdutoRequest.getNome());
        variacao.setDescricao(variacaoProdutoRequest.getDescricao());
        variacao.setProduto(produtoRepository.obterProdutoPorId(variacaoProdutoRequest.getProduto_id()));
        Variacao variacaoSalvo = this.variacaoProdutoRepository.save(variacao);

        VariacaoProdutoResponse variacaoProdutoResponse = new VariacaoProdutoResponse();

        variacaoProdutoResponse.setId(variacaoSalvo.getId());
        variacaoProdutoResponse.setNome(variacaoSalvo.getNome());
        variacaoProdutoResponse.setDescricao(variacaoSalvo.getDescricao());
        variacaoProdutoResponse.setProdutoResponse(modelMapper.map(variacaoSalvo.getProduto(), ProdutoResponse.class));

        return variacaoProdutoResponse;
    }

    public List<Variacao> listarVariacaoProduto() {
        return this.variacaoProdutoRepository.listarVariacaoProduto();
    }

    public VariacaoProdutoResponse retornarVariacaoProduto(Integer id) {
        return modelMapper.map(this.variacaoProdutoRepository.obterVariacaoProdutoPorId(id), VariacaoProdutoResponse.class);
    }

    public VariacaoProdutoResponse atualizarVariacaoProduto(Integer variacaoProdutoId, VariacaoProdutoRequest request) {
        Variacao variacao = this.variacaoProdutoRepository.obterVariacaoProdutoPorId(variacaoProdutoId);
        if (variacao != null) {
            modelMapper.map(request, variacao);
            Variacao variacaoSalva = this.variacaoProdutoRepository.save(variacao);
            return modelMapper.map(variacaoSalva, VariacaoProdutoResponse.class);
        } else {
            throw new IllegalArgumentException("VariacaoProduto não existe");
        }
    }

    public void apagarVariacaoProduto(Integer variacaoProdutoId){
        this.variacaoProdutoRepository.apagarVariacaoProduto(variacaoProdutoId);
    }


}
