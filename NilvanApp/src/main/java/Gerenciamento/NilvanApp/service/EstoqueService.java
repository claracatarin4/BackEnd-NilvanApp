package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.request.EstoqueRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.EstoqueResponse;
import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstoqueService {

    private EstoqueRepository estoqueRepository;

    private ModelMapper modelMapper;
    public EstoqueService(EstoqueRepository estoqueRepository, ModelMapper modelMapper) {
        this.estoqueRepository = estoqueRepository;
        this.modelMapper = modelMapper;
    }
    public EstoqueResponse criarEstoque(EstoqueRequest estoqueRequest){
        Estoque estoque = this.modelMapper.map(estoqueRequest,Estoque.class);
        Estoque estoqueSalvo = this.estoqueRepository.save(estoque);
        EstoqueResponse estoqueResponse = this.modelMapper.map(estoqueSalvo,EstoqueResponse.class);
        return estoqueResponse;
    }
    public List<Estoque> listarEstoques(){
        return this.estoqueRepository.listarEstoque();
    }

    public EstoqueResponse retornarEstoque (Integer id){
        return  modelMapper.map(this.estoqueRepository.obterEstoquePorId(id),EstoqueResponse.class);
    }

    public EstoqueResponse atualizarEstoque(Integer estoqueId, EstoqueRequest request){
        Estoque estoque = this.estoqueRepository.obterEstoquePorId(estoqueId);
        if (estoqueId != null){
            modelMapper.map(request,estoque);
            Estoque estoqueSalvo = this.estoqueRepository.save(estoque);
            return modelMapper.map(estoqueSalvo,EstoqueResponse.class);
        }else{
            throw new IllegalArgumentException("Estoque não existe");
        }
    }

    public void apagarEstoque(Integer estoqueId){
        this.estoqueRepository.apagarEstoque(estoqueId);
    }
}
