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
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {

    @Autowired
    private ModelMapper modelMapper;

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.listarUsuariosAtivos();
    }

    public Usuario listarUsuarioPorId(int idUsuario){
        return this.usuarioRepository.obterUsuarioAtivoPorId(idUsuario);
    }

    public UsuarioResponse salvar(UsuarioRequest usuarioDtoRequest) {
        Usuario usuario = modelMapper.map(usuarioDtoRequest, Usuario.class);
        usuario.setStatus(1);

        Usuario usuarioSave = this.usuarioRepository.save(usuario);

        return modelMapper.map(usuarioSave, UsuarioResponse.class);
    }

    public UsuarioResponse atualizar(@Valid Integer idUsuario, UsuarioRequest usuarioRequest) {
        Usuario usuario = this.listarUsuarioPorId(idUsuario);
        if(usuario!= null){
            modelMapper.map(usuarioRequest, usuario);
            Usuario usuarioTemp = this.usuarioRepository.save(usuario);
            return modelMapper.map(usuarioTemp, UsuarioResponse.class);
        }else{
            return null;
        }
    }

    public void apagar(Integer idUsuario) {
        this.usuarioRepository.apagadoLogico(idUsuario);
    }
}
