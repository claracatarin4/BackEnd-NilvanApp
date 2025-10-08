package Gerenciamento.NilvanApp.service;

import Gerenciamento.NilvanApp.config.SecurityConfiguration;
import Gerenciamento.NilvanApp.dto.request.UsuarioRequest;
import Gerenciamento.NilvanApp.dto.response.UsuarioResponse;
import Gerenciamento.NilvanApp.dto.roles.LoginUserDto;
import Gerenciamento.NilvanApp.dto.roles.RecoveryJwtTokenDto;
import Gerenciamento.NilvanApp.entity.Roles.Role;
import Gerenciamento.NilvanApp.entity.Usuario;
import Gerenciamento.NilvanApp.repository.RoleRepository;
import Gerenciamento.NilvanApp.repository.UsuarioRepository;
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

    private final RoleRepository roleRepository;
    @Autowired
    private SecurityConfiguration securityConfiguration;

    private ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }
    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest) {
        Role role = new Role();
        role= roleRepository.findByName(usuarioRequest.getRole());

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCargo(usuarioRequest.getCargo());
        usuario.setImagem(usuarioRequest.getImagem());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(securityConfiguration.passwordEncoder().encode(usuarioRequest.getSenha()));
        usuario.setStatus(usuarioRequest.getStatus());
        usuario.setRoles(List.of(role));

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

    public Usuario listarUsuarioPorId(int idUsuario){
        return this.usuarioRepository.obterUsuarioPorId(idUsuario);
    }

    public UsuarioResponse salvarUsuario(UsuarioRequest usuarioRequest) {
        Role role = new Role();
        role= roleRepository.findByName(usuarioRequest.getRole());

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCargo(usuarioRequest.getCargo());
        usuario.setImagem(usuarioRequest.getImagem());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(securityConfiguration.passwordEncoder().encode(usuarioRequest.getSenha()));
        usuario.setStatus(1);
        usuario.setRoles(List.of(role));

        Usuario usuarioSave = this.usuarioRepository.save(usuario);

        return modelMapper.map(usuarioSave, UsuarioResponse.class);
    }

    public UsuarioResponse atualizarUsuario(@Valid Integer usuarioId, UsuarioRequest usuarioRequest){
        Usuario usuario = this.usuarioRepository.obterUsuarioPorId(usuarioId);
        if (usuario != null){
            modelMapper.map(usuarioRequest,usuario);
            Usuario usuarioSalvo = this.usuarioRepository.save(usuario);
            return modelMapper.map(usuarioSalvo,UsuarioResponse.class);
        }else{
            return null;
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

}
