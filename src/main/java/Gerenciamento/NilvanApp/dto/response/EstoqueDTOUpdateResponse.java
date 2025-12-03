package Gerenciamento.NilvanApp.dto.response;

import java.util.Date;

public class EstoqueDTOUpdateResponse {

    private Integer id;
    private Integer qntdAtual;
    private Integer qntdMinima;
    private Date atualizado;
    private Date precoCusto;
    private Integer status;

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

    public Date getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Date precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
