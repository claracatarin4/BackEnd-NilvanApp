package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.repository.CategoriaRepository;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService
            (CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategoria() {
        return this.categoriaRepository.findAll();
    }
}
