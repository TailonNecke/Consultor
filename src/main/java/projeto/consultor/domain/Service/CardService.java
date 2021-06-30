package projeto.consultor.domain.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto.consultor.domain.Repository.CardRepository;
import projeto.consultor.domain.model.Card;

@AllArgsConstructor
@Service
public class CardService {

    private CardRepository cardRepository;


}
