package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.EstoqueRequest;
import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.response.EstoqueResponse;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstoqueService {

    @Autowired
    private ModelMapper modelMapper;

    private EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public List<Estoque> listarEstoque() {
        return this.estoqueRepository.findAll();
    }

    public EstoqueResponse criarEstoque(EstoqueRequest estoqueRequest){

        Estoque estoque = modelMapper.map(estoqueRequest,Estoque.class);
        Estoque estoque1= this.estoqueRepository.save(estoque);
        EstoqueResponse estoqueResponse = modelMapper.map(estoque1,EstoqueResponse.class);
        return estoqueResponse;
    }
}
