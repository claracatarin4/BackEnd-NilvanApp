package Gerenciamento.NilvanApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.File;
import java.util.Set;

@Entity
@Table(
        name = "produto"
)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "produto_id")
    private Integer id;
    @Column(name = "produto_nome")
    private String nome;

    @Column(name = "produto_codigo_interno")
    private String codigoInterno;

    @Column(name = "produto_codigo_barras")
    private String codigoBarras;

    @Column(name = "produto_descricao")
    private String descricao;

    @Column(name = "produto_imagem_url")
    private File imagem;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @OneToMany (mappedBy = "usuario")

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public File getImagem() {
        return imagem;
    }

    public void setImagem(File imagem) {
        this.imagem = imagem;
    }

}
