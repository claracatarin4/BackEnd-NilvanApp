package Gerenciamento.NilvanApp.controller;

import Gerenciamento.NilvanApp.dto.request.CategoriaDTOUpdateRequest;
import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaDTOUpdateResponse;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
@CrossOrigin("*")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaResponse>> listarCategorias(){
        return ResponseEntity.ok(categoriaService.listarCategorias());

    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<CategoriaResponse> listarCategoria(@PathVariable("id") Integer categoriaId){
        return ResponseEntity.ok(categoriaService.retornarCategoria(categoriaId));
    }
    @PostMapping("/criar")
    public ResponseEntity<CategoriaResponse> criarCategoria(@Valid @RequestBody CategoriaRequest categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.criarCategoria(categoria));
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<CategoriaResponse> atualizarCategoria(@PathVariable("id") Integer id, @RequestBody
    CategoriaRequest request){
        return ResponseEntity.ok(this.categoriaService.atualizarCategoria(id,request));
    }
    @DeleteMapping("/apagar/{id}")
    public  ResponseEntity apagarCategoria(@PathVariable("id") Integer id){
        this.categoriaService.apagarCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
