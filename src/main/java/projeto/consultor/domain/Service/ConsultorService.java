package projeto.consultor.domain.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projeto.consultor.api.assembler.ConsultorAssembler;
import projeto.consultor.api.model.ConsultorDTO;
import projeto.consultor.domain.Repository.ConsultorRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ConsultorService {

    private ConsultorRepository consultorRepository;
    private ConsultorAssembler consultorAssembler;

    public List<ConsultorDTO> listar(){

        return consultorAssembler.toCollectionModel(consultorRepository.findAll());
    }
}
