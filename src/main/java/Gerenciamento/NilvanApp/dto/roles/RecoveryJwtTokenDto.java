package Gerenciamento.NilvanApp.dto.roles;

import Gerenciamento.NilvanApp.dto.response.UsuarioLoginDTOResponse;

public record RecoveryJwtTokenDto(
        UsuarioLoginDTOResponse usuarioLoginResponse,
        String token
) {
}
