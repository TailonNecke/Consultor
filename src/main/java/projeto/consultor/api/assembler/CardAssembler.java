package projeto.consultor.api.assembler;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import projeto.consultor.api.model.CardDTO;
import projeto.consultor.api.model.input.CardInputDTO;
import projeto.consultor.domain.model.Card;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CardAssembler {

    private ModelMapper modelMapper;

    public CardDTO toModel(Card card){
        return modelMapper.map(card, CardDTO.class);
    }

    public List<CardDTO> toCollectionModel(List<Card> cards){
        return cards.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Card toEntity(CardInputDTO cardInputDTO){
        return modelMapper.map(cardInputDTO, Card.class);
    }
}
