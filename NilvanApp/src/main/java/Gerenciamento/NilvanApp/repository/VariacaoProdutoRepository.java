package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.VariacaoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariacaoProdutoRepository extends JpaRepository<VariacaoProduto,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Usuario c SET c.status = -1 WHERE c.id = :id")
    void apagarVariacaoProduto (@Param("id")Integer variacaoId);

    @Query("SELECT c FROM Usuario c WHERE c.status >= 0")
    List<VariacaoProduto> listarVariacaoProduto();

    @Query("SELECT c FROM Categoria c WHERE c.id = :id")
    VariacaoProduto obterVariacaoProdutoPorId (@Param("id")Integer variacaoId);
}
