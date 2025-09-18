package Gerenciamento.NilvanApp.dto.request;

import java.util.Date;

public class MovimentacaoEstoqueRequest {
    private String tipo;
    private Integer quantidade;
    private Date dataMovimentacao;
    private String observacao;
    private Integer usuario_id;
    private Integer estoque_id;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Integer getEstoque_id() {
        return estoque_id;
    }

    public void setEstoque_id(Integer estoque_id) {
        this.estoque_id = estoque_id;
    }
}
