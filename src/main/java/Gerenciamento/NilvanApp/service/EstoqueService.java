package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.EstoqueRequest;
import Gerenciamento.NilvanApp.dto.response.EstoqueResponse;
import Gerenciamento.NilvanApp.dto.response.VariacaoProdutoResponse;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.VariacaoProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private  final VariacaoProdutoRepository variacaoProdutoRepository;
    private final ModelMapper modelMapper;

    public EstoqueService(EstoqueRepository estoqueRepository, VariacaoProdutoRepository variacaoProdutoRepository, ModelMapper modelMapper) {
        this.estoqueRepository = estoqueRepository;
        this.variacaoProdutoRepository = variacaoProdutoRepository;
        this.modelMapper = modelMapper;
    }

    public EstoqueResponse criarEstoque(EstoqueRequest estoqueRequest) {
        Estoque estoque = new Estoque();
        estoque.setQntdAtual(estoqueRequest.getQntdAtual());
        estoque.setQntdMinima(estoqueRequest.getQntdMinima());
        estoque.setAtualizado(estoqueRequest.getAtualizado());
        estoque.setPrecoVenda(estoqueRequest.getPrecoVenda());
        estoque.setPrecoCusto(estoqueRequest.getPrecoCusto());
        estoque.setStatus(estoqueRequest.getStatus());
        estoque.setVariacaoProduto(variacaoProdutoRepository.obterVariacaoProdutoPorId(estoqueRequest.getVariacaoId()));
        Estoque estoqueSalvo = this.estoqueRepository.save(estoque);

        EstoqueResponse estoqueResponse = new EstoqueResponse();

        estoqueResponse.setQntdAtual(estoqueSalvo.getQntdAtual());
        estoqueResponse.setId(estoqueSalvo.getId());
        estoqueResponse.setQntdMinima(estoqueSalvo.getQntdMinima());
        estoqueResponse.setAtualizado(estoqueSalvo.getAtualizado());
        estoqueResponse.setPrecoVenda(estoqueSalvo.getPrecoVenda());
        estoqueResponse.setPrecoCusto(estoqueSalvo.getPrecoCusto());
        estoqueResponse.setVariacaoProdutoResponse(modelMapper.map(estoqueSalvo.getVariacaoProduto(), VariacaoProdutoResponse.class));

        return estoqueResponse;

    }

    public List<EstoqueResponse> listarEstoques() {
        return this.estoqueRepository.findAll().stream()
                .map(estoque -> modelMapper.map(estoque, EstoqueResponse.class))
                .collect(Collectors.toList());
    }

    public EstoqueResponse retornarEstoque(Integer id) {
        Optional<Estoque> optionalEstoque = this.estoqueRepository.findById(id);
        if (optionalEstoque.isPresent()) {
            return modelMapper.map(optionalEstoque.get(), EstoqueResponse.class);
        } else {
            throw new IllegalArgumentException("Estoque não encontrado com o ID fornecido: " + id);
        }
    }

    public EstoqueResponse atualizarEstoque(Integer estoqueId, EstoqueRequest request) {
        Optional<Estoque> optionalEstoque = this.estoqueRepository.findById(estoqueId);
        if (optionalEstoque.isPresent()) {
            Estoque estoque = optionalEstoque.get();
            modelMapper.map(request, estoque);
            Estoque estoqueSalvo = this.estoqueRepository.save(estoque);
            return modelMapper.map(estoqueSalvo, EstoqueResponse.class);
        } else {
            throw new IllegalArgumentException("Estoque não encontrado com o ID fornecido: " + estoqueId);
        }
    }

    public void apagarEstoque(Integer estoqueId) {
        if (this.estoqueRepository.existsById(estoqueId)) {
            this.estoqueRepository.deleteById(estoqueId);
        } else {
            throw new IllegalArgumentException("Estoque não encontrado com o ID fornecido: " + estoqueId);
        }
    }
}