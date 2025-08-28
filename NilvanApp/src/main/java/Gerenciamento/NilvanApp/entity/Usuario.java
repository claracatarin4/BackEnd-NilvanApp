package Gerenciamento.NilvanApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(
        name = "usuario"
)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "usuario_id")
    private Integer id;
    @Column(name = "usuario_nome")
    private String nome;

    @Column(name = "usuario_cargo")
    private String cargo;

    @Column(name = "usuario_email")
    private String email;

    @Column(name = "usuario_senha")
    private String senha;

    @Column(name = "usuario_imagem_url")
    private String imagemUrl;

    @OneToMany (mappedBy = "usuario")

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}


