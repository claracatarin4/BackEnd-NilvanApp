package Gerenciamento.NilvanApp.controller;

import Gerenciamento.NilvanApp.dto.request.EstoqueRequest;
import Gerenciamento.NilvanApp.dto.response.EstoqueResponse;
import Gerenciamento.NilvanApp.service.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping
    public ResponseEntity<List<EstoqueResponse>> listarEstoque() {
        return ResponseEntity.ok(estoqueService.listarEstoques());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueResponse> listarEstoque(@PathVariable("id") Integer estoqueId) {
        return ResponseEntity.ok(estoqueService.retornarEstoque(estoqueId));
    }

    @PostMapping
    public ResponseEntity<EstoqueResponse> criarEstoque(@Valid @RequestBody EstoqueRequest estoque) {
        EstoqueResponse novoEstoque = estoqueService.criarEstoque(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEstoque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstoqueResponse> atualizarEstoque(@PathVariable("id") Integer id, @Valid @RequestBody EstoqueRequest request) {
        return ResponseEntity.ok(this.estoqueService.atualizarEstoque(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarEstoque(@PathVariable("id") Integer id) {
        this.estoqueService.apagarEstoque(id);
        return ResponseEntity.noContent().build();
    }
}