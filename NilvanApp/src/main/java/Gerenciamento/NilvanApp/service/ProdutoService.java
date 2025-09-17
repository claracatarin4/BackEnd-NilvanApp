package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.controller.ProdutoController;
import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.entity.VariacaoProduto;
import Gerenciamento.NilvanApp.repository.CategoriaRepository;
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
    private CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, ModelMapper modelMapper) {

        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }
    public List<Produto> listarProdutos() {
        return this.produtoRepository.findAll();
    }



    public ProdutoResponse criarProduto(ProdutoRequest produtoRequest){

        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        produto.setDescricao(produtoRequest.getDescricao());
        produto.setCodigoInterno(produtoRequest.getCodigoInterno());
        produto.setCodigoBarras(produtoRequest.getCodigoBarras());
        produto.setCategoria(categoriaRepository.obterCategoriaPorId(produtoRequest.getCategoria_id()));
        produto.setImagem(produtoRequest.getImagem());
        produto.setStatus(produtoRequest.getStatus());
        Produto produtoSave= this.produtoRepository.save(produto);
        ProdutoResponse produtoResponse = modelMapper.map(produtoSave,ProdutoResponse.class);
        return produtoResponse;

    }

    public ProdutoResponse retornarProduto(Integer id){
        return  modelMapper.map(this.produtoRepository.obterProdutoPorId(id),ProdutoResponse.class);
    }

    public ProdutoResponse atualizarProduto(Integer produtoId, ProdutoRequest produtoRequest){
        Produto produto = this.produtoRepository.obterProdutoPorId(produtoId);
        if (produto != null){
            produto.setNome(produtoRequest.getNome());
            produto.setDescricao(produtoRequest.getDescricao());
            produto.setCodigoInterno(produtoRequest.getCodigoInterno());
            produto.setCodigoBarras(produtoRequest.getCodigoBarras());
            produto.setCategoria(categoriaRepository.obterCategoriaPorId(produtoRequest.getCategoria_id()));
            produto.setImagem(produtoRequest.getImagem());
            produto.setStatus(produtoRequest.getStatus());
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
