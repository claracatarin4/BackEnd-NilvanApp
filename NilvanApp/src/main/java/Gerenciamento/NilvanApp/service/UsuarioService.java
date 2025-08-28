package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import Gerenciamento.NilvanApp.entity.Usuario;
import Gerenciamento.NilvanApp.repository.MovimentacaoEstoqueRepository;
import Gerenciamento.NilvanApp.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.findAll();
    }
}
