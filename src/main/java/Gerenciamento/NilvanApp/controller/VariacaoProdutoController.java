package Gerenciamento.NilvanApp.controller;


import Gerenciamento.NilvanApp.dto.request.VariacaoProdutoRequest;
import Gerenciamento.NilvanApp.dto.response.VariacaoProdutoResponse;
import Gerenciamento.NilvanApp.entity.Variacao;
import Gerenciamento.NilvanApp.service.VariacaoProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/variacaoproduto")
@CrossOrigin("*")
public class VariacaoProdutoController {

    private VariacaoProdutoService variacaoProdutoService;

    public VariacaoProdutoController(VariacaoProdutoService variacaoProdutoService) {
        this.variacaoProdutoService = variacaoProdutoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<VariacaoProdutoResponse>> listarVariacoes() {
        return ResponseEntity.ok(variacaoProdutoService.listarVariacoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<VariacaoProdutoResponse> listarVariacao(@PathVariable("id") Integer variacaoProdutoId){
        return ResponseEntity.ok(variacaoProdutoService.retornarVariacaoProduto(variacaoProdutoId));
    }

    @PostMapping("/criar")
    public ResponseEntity<VariacaoProdutoResponse> criarVariacao(@Valid @RequestBody VariacaoProdutoRequest variacaoProduto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(variacaoProdutoService.criarVariacao(variacaoProduto));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<VariacaoProdutoResponse> atualizarVariacao(@PathVariable("id") Integer id, @RequestBody
    VariacaoProdutoRequest request){
        return ResponseEntity.ok(this.variacaoProdutoService.atualizarVariacaoProduto(id,request));
    }

    @DeleteMapping("/apagar/{id}")
    public  ResponseEntity apagarVariacao(@PathVariable("id") Integer id){
        this.variacaoProdutoService.apagarVariacaoProduto(id);
        return ResponseEntity.noContent().build();
    }


}
