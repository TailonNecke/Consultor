package projeto.consultor.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.consultor.domain.model.Consultor;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultorRepository extends JpaRepository<Consultor, Long> {

    List<Consultor> findByNome(String nome);
    List<Consultor> findByNomeContaining(String nome);
    Optional<Consultor> findByEmail(String email);

}
