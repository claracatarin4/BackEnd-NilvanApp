package Gerenciamento.NilvanApp.controller;


import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.service.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/estoque")
public class EstoqueController {

    private EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {

        this.estoqueService = estoqueService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Estoque>> listarEstoque() {
        return ResponseEntity.ok(estoqueService.listarEstoque());
    }


}
