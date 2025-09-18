package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.request.EstoqueRequest;
import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.request.UsuarioRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.EstoqueResponse;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.dto.response.UsuarioResponse;
import Gerenciamento.NilvanApp.entity.*;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.MovimentacaoEstoqueRepository;
import Gerenciamento.NilvanApp.repository.UsuarioRepository;
import Gerenciamento.NilvanApp.repository.VariacaoProdutoRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {

    @Autowired

    private final UsuarioRepository usuarioRepository;

    private ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }
    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest) {

        Usuario usuario = this.modelMapper.map(usuarioRequest,Usuario.class);
        Usuario usuarioSalvo = this.usuarioRepository.save(usuario);
        UsuarioResponse usuarioResponse = this.modelMapper.map(usuarioSalvo,UsuarioResponse.class);
        return usuarioResponse;
    }

    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.ListarUsuario();
    }

    public UsuarioResponse retornarUsuario (Integer id){
        return  modelMapper.map(this.usuarioRepository.obterUsuarioPorId(id),UsuarioResponse.class);
    }

    public UsuarioResponse atualizarUsuario(Integer usuarioId, UsuarioRequest request){
        Usuario usuario = this.usuarioRepository.obterUsuarioPorId(usuarioId);
        if (usuario != null){
            modelMapper.map(request,usuario);
            Usuario usuarioSalvo = this.usuarioRepository.save(usuario);
            return modelMapper.map(usuarioSalvo,UsuarioResponse.class);
        }else{
            throw new IllegalArgumentException("Usuario não existe");
        }
    }


    public void apagarUsuario (Integer usuarioId){
        this.usuarioRepository.apagarUsuario(usuarioId);
    }



}
