package projeto.consultor.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.consultor.domain.model.Consultor;



@Repository
public interface ConsultorRepository extends JpaRepository<Consultor, Long> {
}
