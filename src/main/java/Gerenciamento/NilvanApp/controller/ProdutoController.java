package Gerenciamento.NilvanApp.controller;


import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/produto")
@CrossOrigin("*")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {

        this.produtoService = produtoService;
    }

    @GetMapping({"/listar"})
    public ResponseEntity<List<ProdutoResponse>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ProdutoResponse> listarProduto(@PathVariable("id") Integer produtoId){
        return ResponseEntity.ok(produtoService.retornarProduto(produtoId));
    }

    @PostMapping("/criar")
    public ResponseEntity<ProdutoResponse> criarProduto(@Valid @RequestBody ProdutoRequest produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProduto(produto));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(@PathVariable("id") Integer id, @RequestBody
    ProdutoRequest request){
        return ResponseEntity.ok(this.produtoService.atualizarProduto(id,request));
    }

    @DeleteMapping("/apagar/{id}")
    public  ResponseEntity apagarProduto(@PathVariable("id") Integer id){
        this.produtoService.apagarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
