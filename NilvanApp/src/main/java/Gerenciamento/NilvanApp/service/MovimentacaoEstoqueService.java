package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.MovimentacaoEstoqueRepository;
import Gerenciamento.NilvanApp.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MovimentacaoEstoqueService {

    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
    }

    public List<MovimentacaoEstoque> listarMovimentacaoEstoque() {
        return this.movimentacaoEstoqueRepository.findAll();
    }

}
