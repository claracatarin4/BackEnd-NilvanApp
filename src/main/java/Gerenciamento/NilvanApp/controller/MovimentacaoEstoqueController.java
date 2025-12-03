package Gerenciamento.NilvanApp.controller;

import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.request.MovimentacaoEstoqueRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.MovimentacaoEstoqueResponse;
import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.service.CategoriaService;
import Gerenciamento.NilvanApp.service.MovimentacaoEstoqueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/movimentacao_estoque")
@CrossOrigin("*")
public class MovimentacaoEstoqueController {

    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    public MovimentacaoEstoqueController(MovimentacaoEstoqueService movimentacaoEstoqueService) {
        this.movimentacaoEstoqueService = movimentacaoEstoqueService;
    }

    @GetMapping({"/listar"})
    public ResponseEntity<List<MovimentacaoEstoqueResponse>> listarMovimentacaoEstoque() {
        return ResponseEntity.ok(movimentacaoEstoqueService.listarMovimentacoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<MovimentacaoEstoqueResponse> listarMovimentacaoEstoque(@PathVariable("id") Integer movimentacaoEstoqueId){
        return ResponseEntity.ok(movimentacaoEstoqueService.retornarMovimentacaoEstoque(movimentacaoEstoqueId));
    }
    @PostMapping("/criar")
    public ResponseEntity<MovimentacaoEstoqueResponse> criarMovimentacaoEstoque(@Valid @RequestBody MovimentacaoEstoqueRequest movimentacaoEstoque) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoEstoqueService.criarMovimentacao(movimentacaoEstoque));
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<MovimentacaoEstoqueResponse> atualizarMovimentacaoEstoque(@PathVariable("id") Integer id, @RequestBody
    MovimentacaoEstoqueRequest request){
        return ResponseEntity.ok(this.movimentacaoEstoqueService.atualizarMovimentacaoEstoque(id,request));
    }
    @DeleteMapping("/apagar/{id}")
    public  ResponseEntity apagarMovimentacaoEstoque(@PathVariable("id") Integer id){
        this.movimentacaoEstoqueService.apagarMovimentacaoEstoque(id);
        return ResponseEntity.noContent().build();
    }
}
