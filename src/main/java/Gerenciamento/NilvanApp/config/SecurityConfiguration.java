package Gerenciamento.NilvanApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserAuthenticationFilter userAuthenticationFilter;

    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
            "/api/usuario/criar", // Url que usaremos para criar um usuário
            "/api/usuario/login",

            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",

            "/api/movimentacao_estoque/criar",
            "/api/movimentacao_estoque/listar",
            "/api/movimentacao_estoque/listar/{id}",
            "/api/movimentacao_estoque/atualizar/{id}",
            "/api/movimentacao_estoque/apagar/{id}",
            "/api/estoque/criar",
            "/api/estoque/listar",
            "/api/estoque/listar/{id}",
            "/api/estoque/atualizar/{id}",
            "/api/estoque/apagar/{id}",
            "/api/categoria/criar",
            "/api/categoria/listar",
            "/api/categoria/listar/{id}",
            "/api/categoria/atualizar/{id}",
            "/api/categoria/apagar/{id}",
            "/api/produto/criar",
            "/api/produto/listar",
            "/api/produto/listar/{id}",
            "/api/produto/atualizar/{id}",
            "/api/produto/apagar/{id}",
            "/api/variacaoproduto/criar",
            "/api/variacaoproduto/listar",
            "/api/variacaoproduto/listar/{id}",
            "/api/variacaoproduto/atualizar/{id}",
            "/api/variacaoproduto/apagar/{id}",
            "/api/usuario/criar",
            "/api/usuario/atualizar/{id}",
            "/api/usuario/apagar/{idUsuario}",
            "/api/usuario/listarPorIdUsuario/{idUsuario}",
            "/api/usuario/listar",
            "/api/dashboard/operador",
            "/api/dashboard/admin"
    };

    // Endpoints que requerem autenticação para serem acessados
    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_REQUIRED = {
            "/api/movimentacao_estoque/criar",
            "/api/movimentacao_estoque/listar",
            "/api/movimentacao_estoque/listar/{id}",
            "/api/movimentacao_estoque/atualizar/{id}",
            "/api/movimentacao_estoque/apagar/{id}",
            "/api/estoque/criar",
            "/api/estoque/listar",
            "/api/estoque/listar/{id}",
            "/api/estoque/atualizar/{id}",
            "/api/estoque/apagar/{id}",
            "/api/categoria/criar",
            "/api/categoria/listar",
            "/api/categoria/listar/{id}",
            "/api/categoria/atualizar/{id}",
            "/api/categoria/apagar/{id}",
            "/api/produto/criar",
            "/api/produto/listar",
            "/api/produto/listar/{id}",
            "/api/produto/atualizar/{id}",
            "/api/produto/apagar/{id}",
            "/api/variacaoproduto/criar",
            "/api/variacaoproduto/listar",
            "/api/variacaoproduto/listar/{id}",
            "/api/variacaoproduto/atualizar/{id}",
            "/api/variacaoproduto/apagar/{id}",
            "/api/usuario/criar",
            "/api/usuario/atualizar/{id}",
            "/api/usuario/apagar/{idUsuario}",
            "/api/usuario/listarPorIdUsuario/{idUsuario}",
            "/api/usuario/listar",
            "/api/dashboard/operador",
            "/api/dashboard/admin"
    };

    // Endpoints que só podem ser acessador por usuários com permissão de cliente
    public static final String [] ENDPOINTS_OPERADOR = {
            "/api/movimentacao_estoque/criar",
            "/api/movimentacao_estoque/listar",
            "/api/movimentacao_estoque/listar/{id}",
            "/api/movimentacao_estoque/atualizar/{id}",
            "/api/movimentacao_estoque/apagar/{id}",
            "/api/estoque/criar",
            "/api/estoque/listar",
            "/api/estoque/listar/{id}",
            "/api/estoque/atualizar/{id}",
            "/api/estoque/apagar/{id}",
            "/api/categoria/criar",
            "/api/categoria/listar",
            "/api/categoria/listar/{id}",
            "/api/categoria/atualizar/{id}",
            "/api/categoria/apagar/{id}",
            "/api/produto/criar",
            "/api/produto/listar",
            "/api/produto/listar/{id}",
            "/api/produto/atualizar/{id}",
            "/api/produto/apagar/{id}",
            "/api/variacaoproduto/criar",
            "/api/variacaoproduto/listar",
            "/api/variacaoproduto/listar/{id}",
            "/api/variacaoproduto/atualizar/{id}",
            "/api/variacaoproduto/apagar/{id}",
            "/api/usuario/criar",
            "/api/usuario/atualizar/{id}",
            "/api/usuario/apagar/{idUsuario}",
            "/api/usuario/listarPorIdUsuario/{idUsuario}",
            "/api/usuario/listar",
            "/api/dashboard/operador",
            "/api/dashboard/admin"
    };

    // Endpoints que só podem ser acessador por usuários com permissão de administrador
    public static final String [] ENDPOINTS_ADMIN = {
            "/api/movimentacao_estoque/criar",
            "/api/movimentacao_estoque/listar",
            "/api/movimentacao_estoque/listar/{id}",
            "/api/movimentacao_estoque/atualizar/{id}",
            "/api/movimentacao_estoque/apagar/{id}",
            "/api/estoque/criar",
            "/api/estoque/listar",
            "/api/estoque/listar/{id}",
            "/api/estoque/atualizar/{id}",
            "/api/estoque/apagar/{id}",
            "/api/categoria/criar",
            "/api/categoria/listar",
            "/api/categoria/listar/{id}",
            "/api/categoria/atualizar/{id}",
            "/api/categoria/apagar/{id}",
            "/api/produto/criar",
            "/api/produto/listar",
            "/api/produto/listar/{id}",
            "/api/produto/atualizar/{id}",
            "/api/produto/apagar/{id}",
            "/api/variacaoproduto/criar",
            "/api/variacaoproduto/listar",
            "/api/variacaoproduto/listar/{id}",
            "/api/variacaoproduto/atualizar/{id}",
            "/api/variacaoproduto/apagar/{id}",
            "/api/usuario/criar",
            "/api/usuario/atualizar/{id}",
            "/api/usuario/apagar/{idUsuario}",
            "/api/usuario/listarPorIdUsuario/{idUsuario}",
            "/api/usuario/listar",
            "/api/dashboard/admin"

    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() //adicionado para funcionamento do swagger
                        .requestMatchers(ENDPOINTS_ADMIN).hasRole("ADMIN")
                        .requestMatchers(ENDPOINTS_OPERADOR).hasRole("OPERADOR")
                        .requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_REQUIRED).authenticated()
                        .anyRequest().denyAll()
                )
                .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
