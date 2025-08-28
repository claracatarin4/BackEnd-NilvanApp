package Gerenciamento.NilvanApp.controller;


import Gerenciamento.NilvanApp.entity.VariacaoProduto;
import Gerenciamento.NilvanApp.service.VariacaoProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/variacaoproduto")
public class VariacaoProdutoController {

    private VariacaoProdutoService variacaoProdutoService;

    public VariacaoProdutoController(VariacaoProdutoService variacaoProdutoService) {
        this.variacaoProdutoService = variacaoProdutoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<VariacaoProduto>> listarVariacoes() {
        return ResponseEntity.ok(variacaoProdutoService.listarVariacoes());
    }

}
