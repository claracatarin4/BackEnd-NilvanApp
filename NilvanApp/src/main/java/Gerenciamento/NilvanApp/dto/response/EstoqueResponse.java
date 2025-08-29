package Gerenciamento.NilvanApp.dto.response;

import java.util.Date;

public class EstoqueResponse {

    private Integer id;
    private Integer qntdAtual;
    private Integer qntdMinima;
    private Date atualizado;
    private String estoqueCol;
    private Float precoCusto;
    private Float precoVenda;

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

    public String getEstoqueCol() {
        return estoqueCol;
    }

    public void setEstoqueCol(String estoqueCol) {
        this.estoqueCol = estoqueCol;
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
}
