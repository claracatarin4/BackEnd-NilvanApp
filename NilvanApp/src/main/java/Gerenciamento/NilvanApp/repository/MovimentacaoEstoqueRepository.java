package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Estoque;
import Gerenciamento.NilvanApp.entity.MovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque,Integer> {
}
