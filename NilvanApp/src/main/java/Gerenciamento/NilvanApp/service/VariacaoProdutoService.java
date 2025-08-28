package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.VariacaoProduto;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.ProdutoRepository;
import Gerenciamento.NilvanApp.repository.VariacaoProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VariacaoProdutoService {

    private VariacaoProdutoRepository variacaoProdutoRepository;

    public VariacaoProdutoService(VariacaoProdutoRepository variacaoProdutoRepository) {
        this.variacaoProdutoRepository = variacaoProdutoRepository;
    }

    public List<VariacaoProduto> listarVariacoes() {
        return this.variacaoProdutoRepository.findAll();
    }

}
