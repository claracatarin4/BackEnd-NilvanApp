package Gerenciamento.NilvanApp.controller;

import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.request.UsuarioRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.UsuarioResponse;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import Gerenciamento.NilvanApp.entity.Usuario;
import Gerenciamento.NilvanApp.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());

    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<UsuarioResponse> listarUsuario(@PathVariable("id") Integer usuarioId){
        return ResponseEntity.ok(usuarioService.retornarUsuario(usuarioId));
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioResponse> criarUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(usuarioRequest));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioResponse> atualizarUsuario(@PathVariable("id") Integer id, @RequestBody
    UsuarioRequest request){
        return ResponseEntity.ok(this.usuarioService.atualizarUsuario(id,request));
    }

    @DeleteMapping("/apagar/{id}")
    public  ResponseEntity apagarUsuario(@PathVariable("id") Integer id){
        this.usuarioService.apagarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
