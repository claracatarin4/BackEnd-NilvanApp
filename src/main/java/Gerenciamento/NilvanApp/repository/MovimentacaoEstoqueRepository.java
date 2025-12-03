package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.dto.response.MovimentacaoEstoqueResponse;
import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE MovimentacaoEstoque c SET c.status = -1 WHERE c.id = :id")
    void apagarMovimentacaoEstoque (@Param("id")Integer id);

    @Query("SELECT c FROM MovimentacaoEstoque c WHERE c.status >= 0")
    List<MovimentacaoEstoqueResponse> listarMovimentacaoEstoque();

    @Query("SELECT c FROM MovimentacaoEstoque c WHERE c.id = :id")
    MovimentacaoEstoque obterMovimentacaoEstoquePorId (@Param("id")Integer id);

}
