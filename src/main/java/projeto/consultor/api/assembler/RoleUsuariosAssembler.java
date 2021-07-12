package projeto.consultor.api.assembler;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import projeto.consultor.api.model.RoleUsuariosDTO;
import projeto.consultor.api.model.input.RoleUsuariosInputDTO;
import projeto.consultor.domain.model.RoleUsuarios;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class RoleUsuariosAssembler {

    private ModelMapper modelMapper;

    public RoleUsuariosDTO toModel(RoleUsuarios roleUsuarios){
        return modelMapper.map(roleUsuarios, RoleUsuariosDTO.class);
    }

    public List<RoleUsuariosDTO> toCollectionModel(List<RoleUsuarios> roleUsuarios){
        return roleUsuarios.stream().map(this::toModel).collect(Collectors.toList());
    }

    public RoleUsuarios toEntity(RoleUsuariosInputDTO roleUsuariosInputDTO){
        return modelMapper.map(roleUsuariosInputDTO, RoleUsuarios.class);
    }
}
