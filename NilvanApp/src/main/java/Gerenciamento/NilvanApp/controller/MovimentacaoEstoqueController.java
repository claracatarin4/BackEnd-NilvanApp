package Gerenciamento.NilvanApp.controller;

import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import Gerenciamento.NilvanApp.service.CategoriaService;
import Gerenciamento.NilvanApp.service.MovimentacaoEstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/movimentacao_estoque")
public class MovimentacaoEstoqueController {

    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    public MovimentacaoEstoqueController(MovimentacaoEstoqueService movimentacaoEstoqueService) {
        this.movimentacaoEstoqueService = movimentacaoEstoqueService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MovimentacaoEstoque>> listarMovimentacaoEstoque(){
        return ResponseEntity.ok(movimentacaoEstoqueService.listarMovimentacaoEstoque());

    }
}
