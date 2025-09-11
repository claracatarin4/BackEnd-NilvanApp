package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.controller.ProdutoController;
import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ModelMapper modelMapper;
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {

        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return this.produtoRepository.findAll();
    }



    public ProdutoResponse criarProduto(ProdutoRequest produtoRequest){

        Produto produto = modelMapper.map(produtoRequest,Produto.class);
        Produto produtoSave= this.produtoRepository.save(produto);
        ProdutoResponse produtoResponse = modelMapper.map(produtoSave,ProdutoResponse.class);
        return produtoResponse;

    }

    public ProdutoResponse retornarProduto(Integer id){
        return  modelMapper.map(this.produtoRepository.obterProdutoPorId(id),ProdutoResponse.class);
    }

    public ProdutoResponse atualizarProduto(Integer produtoId, CategoriaRequest request){
        Produto produto = this.produtoRepository.obterProdutoPorId(produtoId);
        if (produto != null){
            modelMapper.map(request,produto);
            Produto produtoSalvo = this.produtoRepository.save(produto);
            return modelMapper.map(produtoSalvo,ProdutoResponse.class);
        }else{
            throw new IllegalArgumentException("Produto não existe");
        }
    }


    public void apagarProduto(Integer produtoId){
        this.produtoRepository.apagarProduto(produtoId);
    }


}
