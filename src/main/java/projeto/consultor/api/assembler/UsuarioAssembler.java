package projeto.consultor.api.assembler;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import projeto.consultor.api.model.UsuarioDTO;
import projeto.consultor.api.model.input.UsuarioInputDTO;
import projeto.consultor.domain.model.Usuario;

@AllArgsConstructor
@Component
public class UsuarioAssembler {
    ModelMapper modelMapper;

    public UsuarioDTO toModel(Usuario usuario){

        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public Usuario toEntity(UsuarioInputDTO usuarioInputDTO){

        return modelMapper.map(usuarioInputDTO, Usuario.class);
    }
}
