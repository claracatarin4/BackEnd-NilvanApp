package Gerenciamento.NilvanApp.dto.request;

import java.util.Date;

public class EstoqueRequest {
    private Integer qntdAtual;
    private Integer qntdMinima;
    private Date atualizado;
    private Float precoCusto;
    private Float precoVenda;
    private  Integer status;
    private Integer variacaoId;

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

    public Integer getVariacaoId() {
        return variacaoId;
    }

    public void setVariacaoId(Integer variacaoId) {
        this.variacaoId = variacaoId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
