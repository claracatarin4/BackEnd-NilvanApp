package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Variacao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariacaoProdutoRepository extends JpaRepository<Variacao,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Variacao c SET c.status = -1 WHERE c.id = :id")
    void apagarVariacaoProduto (@Param("id")Integer id);

    @Query("SELECT c FROM Variacao c WHERE c.status >= 0")
    List<Variacao> listarVariacaoProduto();

    @Query("SELECT c FROM Variacao c WHERE c.id = :id")
    Variacao obterVariacaoProdutoPorId (@Param("id")Integer id);
}
