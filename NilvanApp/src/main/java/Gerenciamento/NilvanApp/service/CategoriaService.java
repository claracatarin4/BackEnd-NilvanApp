package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.repository.CategoriaRepository;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private ModelMapper modelMapper;

    private CategoriaRepository categoriaRepository;

    public CategoriaService
            (CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategoria() {
        return this.categoriaRepository.findAll();
    }

    public CategoriaResponse criarCategoria(CategoriaRequest categoriaRequest){

        Categoria categoria = modelMapper.map(categoriaRequest,Categoria.class);
        Categoria categoria1= this.categoriaRepository.save(categoria);
        CategoriaResponse categoriaResponse = modelMapper.map(categoria1,CategoriaResponse.class);
        return categoriaResponse;
    }
}
