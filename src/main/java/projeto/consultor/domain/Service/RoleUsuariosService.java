package projeto.consultor.domain.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import projeto.consultor.api.assembler.RoleUsuariosAssembler;
import projeto.consultor.api.model.RoleUsuariosDTO;
import projeto.consultor.api.model.input.RoleUsuariosInputDTO;
import projeto.consultor.domain.Repository.RoleUsuariosRepository;
import projeto.consultor.domain.model.RoleUsuarios;

import javax.validation.Valid;

@AllArgsConstructor
@Service
public class RoleUsuariosService {

    private RoleUsuariosRepository roleUsuariosRepository;
    private RoleUsuariosAssembler roleUsuariosAssembler;

    public ResponseEntity<RoleUsuariosDTO> editar(@Valid @PathVariable Long roleUsuariosId, @RequestBody RoleUsuariosInputDTO roleUsuariosInputDTO){
//        if(!roleUsuariosRepository.existsById(roleUsuariosId)){ return ResponseEntity.notFound().build(); }

        RoleUsuarios roled = roleUsuariosRepository.findById(roleUsuariosId).orElse(null);
        roled.setRole_nome_role(roleUsuariosInputDTO.getRole_nome_role());
        roleUsuariosRepository.save(roled);

        return ResponseEntity.ok(roleUsuariosAssembler.toModel(roled));
    }

}
