package Gerenciamento.NilvanApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "variacao_produto")

public class VariacaoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variacao_id")
    private Integer id;
    @Column(name = "variacao_nome")
    private String nome;

    @Column(name = "variacao_descricao")
    private String descricao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "estoque_id", nullable = false)
    private Estoque estoque;


}
