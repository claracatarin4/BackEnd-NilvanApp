package Gerenciamento.NilvanApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_id")
    private Integer id;
    @Column(name = "estoque_quantidade_atual")
    private Integer qntdAtual;
    @Column(name = "estoque_quantidade_minima")
    private Integer qntdMinima;
    @Column(name = "estoque_atualizado_em")
    private Date atualizado;
    @Column(name = "estoque_preco_venda")
    private Float precoVenda;
    @Column(name = "estoque_preco_custo")
    private Float precoCusto;
    @Column(name = "estoque_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "variacao_id", nullable = false)
    @JsonIgnore
    private Variacao variacao;


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

    public Float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Variacao getVariacaoProduto() {
        return variacao;
    }

    public void setVariacaoProduto(Variacao variacao) {
        this.variacao = variacao;
    }
}
