package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE MovimentacaoEstoque c SET c.status = -1 WHERE c.id = :id")
    void apagarMovimentacaoEstoque (@Param("id")Integer movimentacaoEstoqueId);

    @Query("SELECT c FROM MovimentacaoEstoque c WHERE c.status >= 0")
    List<Estoque> listarMovimentacaoEstoque();

    @Query("SELECT c FROM Estoque c WHERE c.id = :id")
    Estoque obterMovimentacaoEstoquePorId (@Param("id")Integer movimentacaoEstoqueId);

}
