package projeto.consultor.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.consultor.domain.Repository.ConsultorRepository;
import projeto.consultor.domain.model.Consultor;
import projeto.consultor.domain.Service.ConsultorService;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/consultor")
public class ConsultorController {

    private ConsultorRepository consultorRepository;
    private ConsultorService consultorService;

    @GetMapping()
    public List<Consultor> listar(){
        return consultorRepository.findAll();
    }

    @GetMapping("/nome/{consultorNome}")
    public List<Consultor> listarPorNome(@PathVariable String consultorNome){
        return consultorRepository.findByNome(consultorNome);
    }

    @PostMapping
    public Consultor cadastrar(@Valid @RequestBody Consultor consultor){
        return consultorService.cadastrar(consultor);
    }

    @DeleteMapping("/{consultorId}")
    public ResponseEntity<Consultor> remover(@PathVariable Long consultorId){
        if(!consultorRepository.existsById(consultorId)){
            return ResponseEntity.notFound().build();
        }

//        pessoaRepository.deleteById(pessoaId);
        consultorService.excluir(consultorId);

        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{consultorId}")
    public ResponseEntity<Consultor> editar(@Valid @PathVariable Long consultorId, @RequestBody Consultor consultor){
        if(!consultorRepository.existsById(consultorId)){
            return ResponseEntity.notFound().build();
        }

        consultor.setId_consultor(consultorId);
        consultor = consultorRepository.save(consultor);

        return ResponseEntity.ok(consultor);
    }
}
