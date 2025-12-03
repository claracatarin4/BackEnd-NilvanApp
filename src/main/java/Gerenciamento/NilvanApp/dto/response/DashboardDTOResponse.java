package Gerenciamento.NilvanApp.dto.response;

public class DashboardDTOResponse {
    private Integer numeroProdutos;
    private Integer totalProdutosEstoque;
    private Double valorEstoque;

    public Integer getNumeroProdutos() {
        return numeroProdutos;
    }

    public void setNumeroProdutos(Integer numeroProdutos) {
        this.numeroProdutos = numeroProdutos;
    }

    public Integer getTotalProdutosEstoque() {
        return totalProdutosEstoque;
    }

    public void setTotalProdutosEstoque(Integer totalProdutosEstoque) {
        this.totalProdutosEstoque = totalProdutosEstoque;
    }

    public Double getValorEstoque() {
        return valorEstoque;
    }

    public void setValorEstoque(Double valorEstoque) {
        this.valorEstoque = valorEstoque;
    }
}
