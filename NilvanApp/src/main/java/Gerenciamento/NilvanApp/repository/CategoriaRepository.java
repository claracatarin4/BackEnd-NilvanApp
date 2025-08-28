package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Categoria;
import Gerenciamento.NilvanApp.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
