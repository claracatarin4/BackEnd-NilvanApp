package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.request.UsuarioRequest;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.dto.response.UsuarioResponse;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import Gerenciamento.NilvanApp.entity.Produto;
import Gerenciamento.NilvanApp.entity.Usuario;
import Gerenciamento.NilvanApp.repository.MovimentacaoEstoqueRepository;
import Gerenciamento.NilvanApp.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {

    @Autowired
    private ModelMapper modelMapper;
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest){

        Usuario usuario = modelMapper.map(usuarioRequest,Usuario.class);
        Usuario usuarioSave= this.usuarioRepository.save(usuario);
        UsuarioResponse usuarioResponse = modelMapper.map(usuarioSave,UsuarioResponse.class);
        return usuarioResponse;
    }
}
