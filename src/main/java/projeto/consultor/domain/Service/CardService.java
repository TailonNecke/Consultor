package projeto.consultor.domain.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import projeto.consultor.api.assembler.CardAssembler;
import projeto.consultor.api.model.CardDTO;
import projeto.consultor.domain.Repository.CardRepository;
import projeto.consultor.domain.model.Card;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Service
public class CardService {

    private CardRepository cardRepository;
    private CardAssembler cardAssembler;

    public ResponseEntity<Card> editar(@Valid @PathVariable Long id_card, @RequestBody Card card){
        if(!cardRepository.existsById(id_card)){ return ResponseEntity.notFound().build(); }
        card.setIdCard(id_card);
        card = cardRepository.save(card);
        return ResponseEntity.ok(card);
    }

    public List<CardDTO> listar(){

        return cardAssembler.toCollectionModel(cardRepository.findAll());
    }

    public List<CardDTO> listarPorSecao(String cardNome){
        return cardAssembler.toCollectionModel(cardRepository.findBySecao(cardNome));
    }

    public List<CardDTO> listarPorStatus(String cardNome){
        return cardAssembler.toCollectionModel(cardRepository.findByStatus(cardNome));
    }

}
