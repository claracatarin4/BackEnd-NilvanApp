package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.MovimentacaoEstoqueRequest;
import Gerenciamento.NilvanApp.dto.response.*;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.MovimentacaoEstoqueRepository;
import Gerenciamento.NilvanApp.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimentacaoEstoqueService {

    @Autowired
    private ModelMapper modelMapper;

    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;
    private final EstoqueRepository estoqueRepository;
    private final UsuarioRepository usuarioRepository;


    @Autowired
    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository movimentacaoEstoqueRepository,UsuarioRepository usuarioRepository, EstoqueRepository estoqueRepository) {
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
        this.estoqueRepository = estoqueRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<MovimentacaoEstoqueResponse> listarMovimentacoes() {
        List<MovimentacaoEstoque> estoques = movimentacaoEstoqueRepository.findAll();
        List<MovimentacaoEstoqueResponse> responses = estoques.stream()
                .map(movimentacaoEstoque -> modelMapper.map(movimentacaoEstoque, MovimentacaoEstoqueResponse.class))
                .collect(Collectors.toList());
        return responses;
    }


    public MovimentacaoEstoqueResponse criarMovimentacao(MovimentacaoEstoqueRequest movimentacaoEstoqueRequest) {

        MovimentacaoEstoque movimentacaoEstoque = new MovimentacaoEstoque();
        movimentacaoEstoque.setTipo(movimentacaoEstoqueRequest.getTipo());
        movimentacaoEstoque.setQuantidade(movimentacaoEstoqueRequest.getQuantidade());
        movimentacaoEstoque.setDataMovimentacao(movimentacaoEstoqueRequest.getDataMovimentacao());
        movimentacaoEstoque.setObservacao(movimentacaoEstoqueRequest.getObservacao());
        movimentacaoEstoque.setEstoque(estoqueRepository.obterEstoquePorId(movimentacaoEstoqueRequest.getEstoque_id()));
        movimentacaoEstoque.setUsuario(usuarioRepository.obterUsuarioPorId(movimentacaoEstoqueRequest.getUsuario_id()));

        MovimentacaoEstoque movimentacaoEstoqueSalvo = this.movimentacaoEstoqueRepository.save(movimentacaoEstoque);


        MovimentacaoEstoqueResponse movimentacaoEstoqueResponse = new MovimentacaoEstoqueResponse();

        movimentacaoEstoqueResponse.setId(movimentacaoEstoqueSalvo.getId());
        movimentacaoEstoqueResponse.setTipo(movimentacaoEstoqueSalvo.getTipo());
        movimentacaoEstoqueResponse.setDataMovimentacao(movimentacaoEstoqueSalvo.getDataMovimentacao());
        movimentacaoEstoqueResponse.setQuantidade(movimentacaoEstoqueSalvo.getQuantidade());
        movimentacaoEstoqueResponse.setObservacao(movimentacaoEstoqueSalvo.getObservacao());
        movimentacaoEstoqueResponse.setEstoqueResponse(modelMapper.map(movimentacaoEstoqueSalvo.getEstoque(), EstoqueResponse.class));
        movimentacaoEstoqueResponse.setUsuarioResponse(modelMapper.map(movimentacaoEstoqueSalvo.getUsuario(), UsuarioResponse.class));

        return movimentacaoEstoqueResponse;
    }


    public MovimentacaoEstoqueResponse retornarMovimentacaoEstoque(Integer id) {
        return modelMapper.map(this.movimentacaoEstoqueRepository.obterMovimentacaoEstoquePorId(id), MovimentacaoEstoqueResponse.class);
    }

    public MovimentacaoEstoqueResponse atualizarMovimentacaoEstoque(Integer movimentacaoEstoqueId, MovimentacaoEstoqueRequest request) {
        MovimentacaoEstoque movimentacaoEstoque = this.movimentacaoEstoqueRepository.obterMovimentacaoEstoquePorId(movimentacaoEstoqueId);
        if (movimentacaoEstoque != null) {
            modelMapper.map(request,movimentacaoEstoque);
            MovimentacaoEstoque movimentacaoEstoqueSalva = this.movimentacaoEstoqueRepository.save(movimentacaoEstoque);
            return modelMapper.map(movimentacaoEstoqueSalva, MovimentacaoEstoqueResponse.class);
        } else {
            throw new IllegalArgumentException("Movimentacao Estoque não existe");
        }
    }

    public void apagarMovimentacaoEstoque(Integer movimentacaoEstoqueId){
        this.movimentacaoEstoqueRepository.apagarMovimentacaoEstoque(movimentacaoEstoqueId);
    }


}