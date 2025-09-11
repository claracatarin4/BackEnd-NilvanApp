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

    @Column(name = "categoria_status")
    private Integer status;

    @OneToMany (mappedBy = "categoria")

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
