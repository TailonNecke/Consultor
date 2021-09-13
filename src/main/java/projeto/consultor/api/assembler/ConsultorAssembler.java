package projeto.consultor.api.assembler;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import projeto.consultor.api.model.ConsultorDTO;
import projeto.consultor.api.model.input.ConsultorInputDTO;
import projeto.consultor.domain.model.Consultor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ConsultorAssembler {

    private ModelMapper modelMapper;

    public ConsultorDTO toModel(Consultor consultor){
        return modelMapper.map(consultor, ConsultorDTO.class);
    }

    public List<ConsultorDTO> toCollectionModel(List<Consultor> consultores){
        return consultores.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Consultor toEntity(ConsultorInputDTO consultorInputDTO){
        return modelMapper.map(consultorInputDTO, Consultor.class);
    }
}
