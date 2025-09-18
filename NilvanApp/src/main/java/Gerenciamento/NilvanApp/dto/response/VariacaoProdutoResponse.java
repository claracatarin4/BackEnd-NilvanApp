package Gerenciamento.NilvanApp.dto.response;

public class VariacaoProdutoResponse {
private Integer id;
    private String nome;
    private String descricao;
    private ProdutoResponse produtoResponse;
    private  Integer status;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ProdutoResponse getProdutoResponse() {
        return produtoResponse;
    }

    public void setProdutoResponse(ProdutoResponse produtoResponse) {
        this.produtoResponse = produtoResponse;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
