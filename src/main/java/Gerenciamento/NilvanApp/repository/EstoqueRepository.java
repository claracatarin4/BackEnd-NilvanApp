package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Integer>{

    @Modifying
    @Transactional
    @Query("UPDATE Estoque c SET c.status = -1 WHERE c.id = :id")
    void apagarEstoque (@Param("id")Integer id);

    @Query("SELECT c FROM Estoque c WHERE c.status >= 0")
    List<Estoque> listarEstoque();

    @Query("SELECT c FROM Estoque c WHERE c.id = :id")
    Estoque obterEstoquePorId (@Param("id")Integer id);


    @Query(value = "SELECT SUM(estoque_quantidade_atual) FROM estoque WHERE estoque_status=1", nativeQuery = true)
    Double getValorEstoque();

    @Query(value = "SELECT SUM(estoque_quantidade_atual * estoque_preco_venda) FROM estoque WHERE estoque_status=1", nativeQuery = true)
    Integer getTotalProdutosEstoque();
}
