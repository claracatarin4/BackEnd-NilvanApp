package Gerenciamento.NilvanApp.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Integer id;
    @Column(name = "categoria_nome")
    private String nome;

    @Column(name = "categoria_descricao")
    private String descricao;

    @OneToMany (mappedBy = "categoria")

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
