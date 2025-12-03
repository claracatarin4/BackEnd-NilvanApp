package Gerenciamento.NilvanApp.dto.response;

import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.Usuario;
import jakarta.persistence.OneToMany;

import java.util.Date;

public class MovimentacaoEstoqueResponse {

    private Integer id;
    private String tipo;
    private Integer quantidade;
    private Date dataMovimentacao;
    private String observacao;
    private Integer movimentacaoStatus;
    private UsuarioResponse usuarioResponse;
    private EstoqueResponse estoqueResponse;

    @OneToMany(mappedBy = "movimentacao_estoque")

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

    public Integer getMovimentacaoStatus() {
        return movimentacaoStatus;
    }

    public void setMovimentacaoStatus(Integer movimentacaoStatus) {
        this.movimentacaoStatus = movimentacaoStatus;
    }

    public UsuarioResponse getUsuarioResponse() {
        return usuarioResponse;
    }

    public void setUsuarioResponse(UsuarioResponse usuarioResponse) {
        this.usuarioResponse = usuarioResponse;
    }

    public EstoqueResponse getEstoqueResponse() {
        return estoqueResponse;
    }

    public void setEstoqueResponse(EstoqueResponse estoqueResponse) {
        this.estoqueResponse = estoqueResponse;
    }
}
