package Gerenciamento.NilvanApp.entity;


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

    @Column(name = "estoque_estoquecol")
    private String estoqueCol;

    @Column(name = "estoque_preco_custo")
    private Date precoCusto;

    @OneToMany (mappedBy = "estoque")

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

    public Date getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Date precoCusto) {
        this.precoCusto = precoCusto;
    }
}
