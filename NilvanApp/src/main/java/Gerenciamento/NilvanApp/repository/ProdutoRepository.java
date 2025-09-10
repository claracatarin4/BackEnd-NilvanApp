package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Produto c SET c.status = -1 WHERE c.id = :id")
    void apagarProduto (@Param("id")Integer produtoId);

    @Query("SELECT c FROM Produto c WHERE c.status >= 0")
    List<Produto> listarProdutos();

    @Query("SELECT c FROM Produto c WHERE c.id = :id")
    Produto obterProdutoPorId (@Param("id")Integer produtoId);
}
