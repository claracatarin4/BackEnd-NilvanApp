package Gerenciamento.NilvanApp.dto.request;

import java.io.File;
import java.util.Date;

public class MovimentacaoEstoqueRequest {
    private String tipo;
    private Integer quantidade;
    private Date movimentacao;
    private String observacao;
    private Integer usuario_id;
    private Integer estoque_id;


}
