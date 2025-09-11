package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.request.VariacaoProdutoRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.dto.response.VariacaoProdutoResponse;
import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.entity.VariacaoProduto;
import Gerenciamento.NilvanApp.repository.CategoriaRepository;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.ProdutoRepository;
import Gerenciamento.NilvanApp.repository.VariacaoProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VariacaoProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    private VariacaoProdutoRepository variacaoProdutoRepository;

    public VariacaoProdutoService(VariacaoProdutoRepository variacaoProdutoRepository) {
        this.variacaoProdutoRepository = variacaoProdutoRepository;
    }

    public List<VariacaoProduto> listarVariacoes() {
        return this.variacaoProdutoRepository.findAll();
    }


    public VariacaoProdutoResponse criarVariacao(VariacaoProdutoRequest variacaoProdutoRequest) {

        VariacaoProduto variacaoProduto = modelMapper.map(variacaoProdutoRequest, VariacaoProduto.class);
        VariacaoProduto variacaoProdutoSalvo = this.variacaoProdutoRepository.save(variacaoProduto);
        VariacaoProdutoResponse variacaoProdutoResponse = modelMapper.map(variacaoProdutoSalvo, VariacaoProdutoResponse.class);
        return variacaoProdutoResponse;
    }

    public List<VariacaoProduto> listarVariacaoProduto() {
        return this.variacaoProdutoRepository.listarVariacaoProduto();
    }

    public VariacaoProdutoResponse retornarVariacaoProduto(Integer id) {
        return modelMapper.map(this.variacaoProdutoRepository.obterVariacaoProdutoPorId(id), VariacaoProdutoResponse.class);
    }

    public VariacaoProdutoResponse atualizarVariacaoProduto(Integer variacaoProdutoId, VariacaoProdutoRequest request) {
        VariacaoProduto variacaoProduto = this.variacaoProdutoRepository.obterVariacaoProdutoPorId(variacaoProdutoId);
        if (variacaoProduto != null) {
            modelMapper.map(request, variacaoProduto);
            VariacaoProduto variacaoProdutoSalva = this.variacaoProdutoRepository.save(variacaoProduto);
            return modelMapper.map(variacaoProdutoSalva, VariacaoProdutoResponse.class);
        } else {
            throw new IllegalArgumentException("VariacaoProduto não existe");
        }
    }

    public void apagarVariacaoProduto(Integer variacaoProdutoId){
        this.variacaoProdutoRepository.apagarVariacaoProduto(variacaoProdutoId);
    }


}
