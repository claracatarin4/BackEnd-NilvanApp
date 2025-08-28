package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.VariacaoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariacaoProdutoRepository extends JpaRepository<VariacaoProduto,Integer> {
}
