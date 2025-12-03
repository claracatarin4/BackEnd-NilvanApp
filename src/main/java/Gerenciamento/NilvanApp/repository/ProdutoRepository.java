package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.dto.response.ProdutoResponse;
import Gerenciamento.NilvanApp.entity.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Produto c SET c.status = -1 WHERE c.id = :id")
    void apagarProduto (@Param("id")Integer id);

    @Query("SELECT c FROM Produto c WHERE c.status >= 0")
    List<ProdutoResponse> listarProdutos();

    @Query("SELECT c FROM Produto c WHERE c.id = :id")
    Produto obterProdutoPorId (@Param("id")Integer id);
    @Query(value = "SELECT COUNT(*) FROM produto WHERE produto_status=1", nativeQuery = true)
    Integer getNumeroProdutos();
}
