package Gerenciamento.NilvanApp.dto.response;

import java.util.Date;

public class EstoqueResponse {

    private Integer id;
    private Integer qntdAtual;
    private Integer qntdMinima;
    private Date atualizado;
    private Float precoCusto;
    private Float precoVenda;
    private VariacaoProdutoResponse variacaoProdutoResponse;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQntdAtual() {
        return qntdAtual;
    }

    public void setQntdAtual(Integer qntdAtual) {
        this.qntdAtual = qntdAtual;
    }

    public Integer getQntdMinima() {
        return qntdMinima;
    }

    public void setQntdMinima(Integer qntdMinima) {
        this.qntdMinima = qntdMinima;
    }

    public Date getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(Date atualizado) {
        this.atualizado = atualizado;
    }

    public Float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public VariacaoProdutoResponse getVariacaoProdutoResponse() {
        return variacaoProdutoResponse;
    }

    public void setVariacaoProdutoResponse(VariacaoProdutoResponse variacaoProdutoResponse) {
        this.variacaoProdutoResponse = variacaoProdutoResponse;
    }


}
