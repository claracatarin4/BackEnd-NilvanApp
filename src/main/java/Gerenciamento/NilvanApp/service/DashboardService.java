package Gerenciamento.NilvanApp.service;


import Gerenciamento.NilvanApp.dto.response.DashboardDTOResponse;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private final ProdutoRepository produtoRepository;
    private final EstoqueRepository estoqueRepository;

    public DashboardService(ProdutoRepository produtoRepository, EstoqueRepository estoqueRepository) {
        this.produtoRepository = produtoRepository;
        this.estoqueRepository = estoqueRepository;
    }

    public DashboardDTOResponse obterDashboardAdmin(){
        DashboardDTOResponse dashboardDTOResponse = new DashboardDTOResponse();
        dashboardDTOResponse.setNumeroProdutos(produtoRepository.getNumeroProdutos());
        dashboardDTOResponse.setValorEstoque(estoqueRepository.getValorEstoque());
        dashboardDTOResponse.setTotalProdutosEstoque(estoqueRepository.getTotalProdutosEstoque());
        return  dashboardDTOResponse;
    }

    public DashboardDTOResponse obterDashboardOperador(){
        DashboardDTOResponse dashboardDTOResponse = new DashboardDTOResponse();
        dashboardDTOResponse.setNumeroProdutos(produtoRepository.getNumeroProdutos());
        dashboardDTOResponse.setTotalProdutosEstoque(estoqueRepository.getTotalProdutosEstoque());
        return  dashboardDTOResponse;
    }
}
