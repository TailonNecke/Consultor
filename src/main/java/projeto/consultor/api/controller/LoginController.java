package projeto.consultor.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

        @PostMapping("/authenticate")
        public ResponseEntity<?> createAuthenticationToken (@RequestBody Usuario usuario) throws Exception{
            try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword())
            );
            } catch (BadCredentialsException ex) {
                throw new Exception("Usuário ou senha invalidos.", ex);
            }
            final UserDetails userDetails = implementsUserDetailsService.loadUserByUsername(
                    usuario.getUsername()
            );
            final String jwt = jwtUtil.generateToken(userDetails);
            return  ResponseEntity.ok(new AuthenticationResponse(jwt));
        }
}
