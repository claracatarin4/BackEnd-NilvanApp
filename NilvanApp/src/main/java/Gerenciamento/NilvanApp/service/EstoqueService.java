package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstoqueService {

    private EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public List<Estoque> listarEstoque() {
        return this.estoqueRepository.findAll();
    }

}
