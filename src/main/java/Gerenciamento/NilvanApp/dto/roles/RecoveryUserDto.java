package Gerenciamento.NilvanApp.dto.roles;

import Gerenciamento.NilvanApp.entity.Roles.Role;

import java.util.List;

public record RecoveryUserDto(
        Long id,
        String email,
        List<Role> roles
) {
}
