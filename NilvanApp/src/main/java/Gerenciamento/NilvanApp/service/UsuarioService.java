package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.config.SecurityConfiguration;
import Gerenciamento.NilvanApp.dto.request.CategoriaRequest;
import Gerenciamento.NilvanApp.dto.request.EstoqueRequest;
import Gerenciamento.NilvanApp.dto.request.ProdutoRequest;
import Gerenciamento.NilvanApp.dto.request.UsuarioRequest;
import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.dto.response.EstoqueResponse;
import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.dto.response.UsuarioResponse;
import Gerenciamento.NilvanApp.dto.roles.CreateUserDto;
import Gerenciamento.NilvanApp.dto.roles.LoginUserDto;
import Gerenciamento.NilvanApp.dto.roles.RecoveryJwtTokenDto;
import Gerenciamento.NilvanApp.entity.*;
import Gerenciamento.NilvanApp.entity.Roles.Role;
import Gerenciamento.NilvanApp.repository.EstoqueRepository;
import Gerenciamento.NilvanApp.repository.MovimentacaoEstoqueRepository;
import Gerenciamento.NilvanApp.repository.UsuarioRepository;
import Gerenciamento.NilvanApp.repository.VariacaoProdutoRepository;
import Gerenciamento.NilvanApp.service.UserService.JwtTokenService;
import Gerenciamento.NilvanApp.service.UserService.UserDetailsImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    private ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }
    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest) {

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCargo(usuarioRequest.getCargo());
        usuario.setImagem(usuarioRequest.getImagem());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setStatus(usuarioRequest.getStatus());
        Usuario usuarioSalvo = this.usuarioRepository.save(usuario);

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(usuarioSalvo.getId());
        usuarioResponse.setNome(usuarioSalvo.getNome());
        usuarioResponse.setCargo(usuarioSalvo.getCargo());
        usuarioResponse.setImagem(usuarioSalvo.getImagem());
        usuarioResponse.setEmail(usuarioSalvo.getEmail());
        usuarioResponse.setSenha(usuarioSalvo.getSenha());
        usuarioResponse.setStatus(usuarioSalvo.getStatus());

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


    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

    // Método responsável por criar um usuário
    public void createUser(CreateUserDto createUserDto) {
        Role role = new Role();
        role.setName(createUserDto.role());

        Usuario newUser = new Usuario();
        newUser.setEmail(createUserDto.email());
        newUser.setSenha(securityConfiguration.passwordEncoder().encode(createUserDto.password()));
        newUser.setRoles(List.of(role));

        // Cria um novo usuário com os dados fornecidos
        /*
        User newUser = User.builder()
                .email(createUserDto.email())
                // Codifica a senha do usuário com o algoritmo bcrypt
                .password(securityConfiguration.passwordEncoder().encode(createUserDto.password()))
                // Atribui ao usuário uma permissão específica
                .roles(List.of(Role.builder().name(createUserDto.role()).build()))
                .build();
         */
        // Salva o novo usuário no banco de dados
        usuarioRepository.save(newUser);
    }


}
