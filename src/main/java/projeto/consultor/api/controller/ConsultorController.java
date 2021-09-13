package projeto.consultor.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projeto.consultor.api.model.ConsultorDTO;
import projeto.consultor.domain.Service.ConsultorService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/consultor")
public class ConsultorController {

    private ConsultorService consultorService;


    @GetMapping()
    public List<ConsultorDTO> listar(){

        return consultorService.listar();
    }

}
