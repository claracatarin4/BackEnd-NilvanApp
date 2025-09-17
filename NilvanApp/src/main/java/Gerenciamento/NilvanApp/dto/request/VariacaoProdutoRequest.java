package Gerenciamento.NilvanApp.dto.request;

import Gerenciamento.NilvanApp.entity.Produto;

public class VariacaoProdutoRequest {

    private String nome;
    private String descricao;
    private Integer produto_id;
    private  Integer status;

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

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
