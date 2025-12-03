package Gerenciamento.NilvanApp.repository;

import Gerenciamento.NilvanApp.entity.Roles.Role;
import Gerenciamento.NilvanApp.entity.Roles.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(RoleName role);
}
