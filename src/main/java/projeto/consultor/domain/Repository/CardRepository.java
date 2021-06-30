package projeto.consultor.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.consultor.domain.model.Card;

import java.util.List;


    @Repository
    public interface CardRepository extends JpaRepository<Card, Long> {

        List<Card> findBySecao(String secao);
        List<Card> findByStatus(String status);

    }
