package projeto.consultor.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projeto.consultor.domain.model.RoleUsuarios;

@Repository
public interface RoleUsuariosRepository extends JpaRepository<RoleUsuarios, Long> {

    @Query("select ru from RoleUsuarios ru where ru.usuario_id = ?1")
    RoleUsuarios findByIdUsuario(Long roleUsuariosId);
}
