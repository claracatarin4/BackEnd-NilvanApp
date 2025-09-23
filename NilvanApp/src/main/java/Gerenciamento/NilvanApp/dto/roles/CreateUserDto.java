package Gerenciamento.NilvanApp.dto.roles;

import Gerenciamento.NilvanApp.entity.Roles.RoleName;

public record CreateUserDto(
        String email,
        String password,
        RoleName role
) {
}
