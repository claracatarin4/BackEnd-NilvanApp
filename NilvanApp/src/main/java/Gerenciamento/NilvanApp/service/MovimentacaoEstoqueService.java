package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.MovimentacaoEstoqueRequest;
import Gerenciamento.NilvanApp.dto.response.MovimentacaoEstoqueResponse;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import Gerenciamento.NilvanApp.repository.MovimentacaoEstoqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoEstoqueService {

    @Autowired
    private ModelMapper modelMapper;

    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    @Autowired
    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
    }

    public List<MovimentacaoEstoque> listarMovimentacaoEstoque() {
        return this.movimentacaoEstoqueRepository.findAll();
    }

    public MovimentacaoEstoqueResponse atualizarMovimentacaoEstoque(Integer movimentacaoEstoqueId, MovimentacaoEstoqueRequest request) {
        Optional<MovimentacaoEstoque> optionalMovimentacaoEstoque = this.movimentacaoEstoqueRepository.findById(movimentacaoEstoqueId);

        if (optionalMovimentacaoEstoque.isPresent()) {
            MovimentacaoEstoque movimentacaoEstoque = optionalMovimentacaoEstoque.get();
            modelMapper.map(request, movimentacaoEstoque);
            MovimentacaoEstoque movimentacaoEstoqueSalvo = this.movimentacaoEstoqueRepository.save(movimentacaoEstoque);
            return modelMapper.map(movimentacaoEstoqueSalvo, MovimentacaoEstoqueResponse.class);
        } else {
            throw new IllegalArgumentException("Movimentação de Estoque não encontrada com o ID fornecido: " + movimentacaoEstoqueId);
        }
    }

    public MovimentacaoEstoqueResponse criarMovimentacaoEstoque(MovimentacaoEstoqueRequest movimentacaoEstoqueRequest) {
        MovimentacaoEstoque movimentacaoEstoque = modelMapper.map(movimentacaoEstoqueRequest, MovimentacaoEstoque.class);
        MovimentacaoEstoque movimentacaoEstoqueSalva = this.movimentacaoEstoqueRepository.save(movimentacaoEstoque);
        return modelMapper.map(movimentacaoEstoqueSalva, MovimentacaoEstoqueResponse.class);
    }
}