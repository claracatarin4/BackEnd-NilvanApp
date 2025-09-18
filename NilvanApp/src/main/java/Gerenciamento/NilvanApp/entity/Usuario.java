package Gerenciamento.NilvanApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.File;

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

    @Column(name = "usuario_senha_hash")
    private String senha;

    @Column(name = "usuario_imagem")
    private byte[] imagem;

    @Column(name = "usuario_status")
    private Integer status;


    @OneToMany (mappedBy = "usuario")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}


