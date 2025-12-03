package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.dto.response.CategoriaResponse;
import Gerenciamento.NilvanApp.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Categoria c SET c.status = -1 WHERE c.id = :id")
    void apagarCategoria (@Param("id")Integer id);

    @Query("SELECT c FROM Categoria c WHERE c.status >= 0")
    List<CategoriaResponse> listarCategoria();

    @Query("SELECT c FROM Categoria c WHERE c.id = :id")
    Categoria obterCategoriaPorId (@Param("id")Integer id);

}
