package projeto.consultor.domain.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import projeto.consultor.domain.Repository.UsuarioRepository;
import projeto.consultor.domain.exception.NegocioException;
import projeto.consultor.domain.model.Usuario;

@AllArgsConstructor
@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if(usuario == null){
            throw new NegocioException("Usuario ou senha invalido.");
        }

        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                true,
                true,
                true,
                true,
                usuario.getAuthorities()
        );
    }
}
