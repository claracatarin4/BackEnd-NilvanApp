package Gerenciamento.NilvanApp.dto.response;

public class MovimentacaoEstoqueDTOUpdateResponse {

    private Integer id;
    private String tipo;
    private Integer quantidade;
    private Integer movimentacao;
    private String observacao;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Integer movimentacao) {
        this.movimentacao = movimentacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
