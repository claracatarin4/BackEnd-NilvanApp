package Gerenciamento.NilvanApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(
        name = "movimentacao_estoque"
)
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimentacao_id")
    private Integer id;

    @Column(name = "movimentacao_tipo")
    private String tipo;

    @Column(name = "movimentacao_quantidade")
    private Integer quantidade;

    @Column(name = "movimentacao_data_movimentacao")
    private Integer movimentacao;


    @Column(name = "movimentacao_observacao")
    private String observacao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "estoque_id", nullable = false)
    private Estoque estoque;


    @OneToMany (mappedBy = "movimentacao_estoque")

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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Integer movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
