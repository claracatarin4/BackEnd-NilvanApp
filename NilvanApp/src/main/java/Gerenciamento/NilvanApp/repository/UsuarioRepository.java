package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Usuario c SET c.status = -1 WHERE c.id = :id")
    void apagarUsuario (@Param("id")Integer id);

    @Query("SELECT c FROM Usuario c WHERE c.status >= 0")
    List<Usuario> ListarUsuario();

    @Query("SELECT c FROM Usuario c WHERE c.id = :id")
    Usuario obterUsuarioPorId (@Param("id")Integer id);

    Optional<Usuario> findByEmail(String email);
}
