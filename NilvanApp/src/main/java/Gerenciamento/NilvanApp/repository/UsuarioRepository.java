package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Usuario c SET c.status = -1 WHERE c.id = :id")
    void apagarUsuario (@Param("id")Integer usuarioId);

    @Query("SELECT c FROM Usuario c WHERE c.status >= 0")
    List<Usuario> listarUsuarios();

    @Query("SELECT c FROM Categoria c WHERE c.id = :id")
    Usuario obterUsuarioPorId (@Param("id")Integer usuarioId);
}
