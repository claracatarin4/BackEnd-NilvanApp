package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.MovimentacaoEstoqueRequest;
import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.response.MovimentacaoEstoqueResponse;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.MovimentacaoEstoqueRepository;
import Gerenciamento.NilvanApp.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MovimentacaoEstoqueService {

    @Autowired
    private ModelMapper modelMapper;

    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository movimentacaoEstoqueRepository) {
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
    }

    public List<MovimentacaoEstoque> listarMovimentacaoEstoque() {
        return this.movimentacaoEstoqueRepository.findAll();
    }
    public MovimentacaoEstoqueResponse atualizarMovimentacaoEstoque(Integer movimentacaoEstoqueId, MovimentacaoEstoqueRequest request){
        MovimentacaoEstoque movimentacaoEstoque = this.estoqueRepository.obterMovimentacaoEstoquePorId(movimentacaoEstoqueId);
        if (movimentacaoEstoqueId != null){
            modelMapper.map(request,estoque);
            MovimentacaoEstoque movimentacaoestoqueSalvo = this.estoqueRepository.save(movimentacaoEstoque);
            return modelMapper.map(movimentacaoestoqueSalvo,MovimentacaoEstoqueResponse.class);
        }else{
            throw new IllegalArgumentException("Movimentaçãpo Estoque não existe");
        }
    }
    public MovimentacaoEstoqueResponse criarMovimentacaoEstoque(MovimentacaoEstoqueRequest movimentacaoEstoqueRequest){

        MovimentacaoEstoque movimentacaoEstoque = modelMapper.map(movimentacaoEstoqueRequest,MovimentacaoEstoque.class);
        MovimentacaoEstoque movimentacaoEstoque1= this.movimentacaoEstoqueRepository.save(movimentacaoEstoque);
        MovimentacaoEstoqueResponse movimentacaoEstoqueResponse = modelMapper.map(movimentacaoEstoque1,MovimentacaoEstoqueResponse.class);
        return movimentacaoEstoqueResponse;
    }

}
