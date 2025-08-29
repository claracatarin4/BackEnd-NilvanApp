package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.request.VariacaoProdutoRequest;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.dto.response.VariacaoProdutoResponse;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.entity.VariacaoProduto;
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


        public VariacaoProdutoResponse crirVariacao(VariacaoProdutoRequest variacaoProdutoRequest){

        VariacaoProduto variacaoProduto = modelMapper.map(variacaoProdutoRequest,VariacaoProduto.class);
        VariacaoProduto variacaoProduto1= this.variacaoProdutoRepository.save(variacaoProduto);
        VariacaoProdutoResponse variacaoProdutoResponse = modelMapper.map(variacaoProduto1,VariacaoProdutoResponse.class);
        return variacaoProdutoResponse;
    }

}
