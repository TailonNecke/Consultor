package projeto.consultor.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projeto.consultor.api.model.RoleUsuariosDTO;
import projeto.consultor.api.model.input.RoleUsuariosInputDTO;
import projeto.consultor.domain.Service.RoleUsuariosService;

@AllArgsConstructor
@RestController
@RequestMapping("/roleUsuarios")
public class RoleUsuarioController {


    private RoleUsuariosService roleUsuariosService;

    @PutMapping("/{roleUsuariosId}")
    public RoleUsuariosDTO editar(@PathVariable Long roleUsuariosId, @RequestBody RoleUsuariosInputDTO roleUsuariosInputDTO) {
        RoleUsuariosDTO roleUsuariosDTO = roleUsuariosService.editar(roleUsuariosId, roleUsuariosInputDTO).getBody();
        return roleUsuariosDTO;
    }

}
