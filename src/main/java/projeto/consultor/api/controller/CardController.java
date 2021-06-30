package projeto.consultor.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.consultor.domain.Repository.CardRepository;
import projeto.consultor.domain.Service.CardService;
import projeto.consultor.domain.model.Card;
import projeto.consultor.domain.model.Consultor;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/card")
public class CardController {

    private CardService cardService;
    private CardRepository cardRepository;

    @GetMapping()
    public List<Card> listar(){
        return cardRepository.findAll();
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<Card> editar(@Valid @PathVariable Long cardId, @RequestBody Card card){
        if(!cardRepository.existsById(cardId)){
            return ResponseEntity.notFound().build();
        }

       card.setIdCard(cardId);

        Optional<Card>cards;
        cards = cardRepository.findById(cardId);
        card.setSecao(cards.get().getSecao());
        card.setCodProjeto(cards.get().getCodProjeto());
        card.setDescProjeto(cards.get().getDescProjeto());
        card.setStatus(cards.get().getStatus());
        card.setDataInicio(cards.get().getDataInicio());
        card.setDataEncerramento(cards.get().getDataEncerramento());
        card = cardRepository.save(card);
        return ResponseEntity.ok(card);
    }

    @GetMapping("/secao/{cardSecao}")
    public List<Card> listarPorSecao(@PathVariable String cardSecao){
        return cardRepository.findBySecao(cardSecao);
    }
    @GetMapping("/status/{cardStatus}")
    public List<Card> listarPorStatus(@PathVariable String cardStatus){
        return cardRepository.findByStatus(cardStatus);
    }
}
