package Gerenciamento.NilvanApp.controller;

import Gerenciamento.NilvanApp.dto.request.UsuarioRequest;
import Gerenciamento.NilvanApp.dto.response.UsuarioResponse;
import Gerenciamento.NilvanApp.dto.roles.LoginUserDto;
import Gerenciamento.NilvanApp.dto.roles.RecoveryJwtTokenDto;
import Gerenciamento.NilvanApp.entity.Usuario;
import Gerenciamento.NilvanApp.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar usuarios do sistema")
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/listarPorIdUsuario/{idUsuario}")
    @Operation(summary = "Listar usuarios do sistema pelo id do usuário")
    public ResponseEntity<Usuario> listarPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
        Usuario usuario = usuarioService.listarUsuarioPorId(idUsuario);
        if (usuario == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(usuario);
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar um novo usuario")
    public ResponseEntity<UsuarioResponse>criar(@Valid @RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioRequest));
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar todos os dados um usuario")
    public ResponseEntity<UsuarioResponse> atualizar(
            @Valid @PathVariable("idUsuario") Integer idUsuario,
            @RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(idUsuario, usuarioRequest));
    }
    @DeleteMapping("/apagar/{idUsuario}")
    @Operation(summary = "Apagar usuario pelo idUsuario")
    public ResponseEntity<UsuarioResponse> apagar(@PathVariable("idUsuario") Integer idUsuario){
        usuarioService.apagarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> authenticateUser (@RequestBody LoginUserDto loginUserDto){
        RecoveryJwtTokenDto token = usuarioService.authenticateUser(loginUserDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}

