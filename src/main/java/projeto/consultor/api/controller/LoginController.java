package projeto.consultor.api.controller;


import lombok.AllArgsConstructor;
import org.jboss.jandex.TypeTarget;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projeto.consultor.api.assembler.UsuarioAssembler;
import projeto.consultor.api.model.input.UsuarioInputDTO;
import projeto.consultor.domain.model.AuthenticationResponse;
import projeto.consultor.domain.model.Usuario;
import projeto.consultor.security.ImplementsUserDetailsService;
import projeto.consultor.security.JWTUtil;

@AllArgsConstructor
@RestController
public class LoginController {

    private AuthenticationManager authenticationManager;
    private ImplementsUserDetailsService implementsUserDetailsService;
    private JWTUtil jwtUtil;
    private UsuarioAssembler usuarioAssembler;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UsuarioInputDTO usuarioInputDTO) throws Exception{
        Usuario usuario = usuarioAssembler.toEntity(usuarioInputDTO);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            usuario.getUsername(), usuario.getPassword())
            );
        } catch (BadCredentialsException ex){
            throw new Exception("Usuário ou senha inválidos.", ex);
        }

        final UserDetails userDetails = implementsUserDetailsService
                .loadUserByUsername(usuario.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, usuarioAssembler.toModel(usuario)));
    }

}
