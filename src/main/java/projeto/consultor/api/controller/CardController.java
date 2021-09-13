package projeto.consultor.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.consultor.api.assembler.CardAssembler;
import projeto.consultor.api.model.CardDTO;
import projeto.consultor.api.model.input.CardInputDTO;
import projeto.consultor.domain.Repository.CardRepository;
import projeto.consultor.domain.Service.CardService;
import projeto.consultor.domain.model.Card;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/card")
public class CardController {

    private CardService cardService;
    private CardRepository cardRepository;
    private CardAssembler cardAssembler;

    @PutMapping("/{id_card}")
    public CardDTO editar(@Valid @PathVariable Long id_card, @RequestBody CardInputDTO cardInputDTO){
//        if(!cardRepository.existsById(cardId)){
//            return ResponseEntity.notFound().build();
//        }

        Card card = cardAssembler.toEntity(cardInputDTO);

        card.setIdCard(id_card);

        Optional<Card>cards;
        cards = cardRepository.findById(id_card);
        card.setIdCard(cards.get().getIdCard());
        card.setSecao(cards.get().getSecao());
        card.setCodProjeto(cards.get().getCodProjeto());
        card.setDescProjeto(cards.get().getDescProjeto());
        card.setStatus(cards.get().getStatus());
        card.setDataInicio(cards.get().getDataInicio());
        card.setDataEncerramento(cards.get().getDataEncerramento());
        card = cardRepository.save(card);
        ResponseEntity<Card> cardResponseEntity = cardService.editar(id_card, card);
        return cardAssembler.toModel(cardResponseEntity.getBody());
    }

    @GetMapping()
    public List<CardDTO> listar(){

        return cardService.listar();
    }

    @GetMapping("/secao/{cardSecao}")
    public List<CardDTO> listarPorSecao(@PathVariable String cardSecao){
        return cardService.listarPorSecao(cardSecao);
    }

    @GetMapping("/status/{cardStatus}")
    public List<CardDTO> listarPorStatus(@PathVariable String cardStatus){
        return cardService.listarPorStatus(cardStatus);
    }
}
