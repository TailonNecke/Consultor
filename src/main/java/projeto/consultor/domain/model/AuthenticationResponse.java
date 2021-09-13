package projeto.consultor.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import projeto.consultor.api.model.UsuarioDTO;

@Getter
@AllArgsConstructor
public class AuthenticationResponse {

    private String jwt;
    private UsuarioDTO usuario;

}
