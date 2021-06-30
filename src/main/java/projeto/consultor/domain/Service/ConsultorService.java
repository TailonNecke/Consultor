package projeto.consultor.domain.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto.consultor.domain.Repository.ConsultorRepository;
import projeto.consultor.domain.exception.NegocioException;
import projeto.consultor.domain.model.Consultor;

@AllArgsConstructor
@Service
public class ConsultorService {

    private ConsultorRepository consultorRepository;

    @Transactional
    public Consultor cadastrar(Consultor consultor) {
        boolean emailValidation = consultorRepository.findByEmail(consultor.getEmail()).isPresent();

        if (emailValidation) {
            throw new NegocioException("Já existe uma pessoa com este e-mail cadastrado.");
        }

        return consultorRepository.save(consultor);
    }

    @Transactional
    public void excluir(Long consultorId) {
        consultorRepository.deleteById(consultorId);
    }
}
