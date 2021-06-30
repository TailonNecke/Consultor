package projeto.consultor.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CardDTO {

    private Long id_card;
    private String secao;
    private Long codProjeto;
    private String descProjeto;
    private String status;
    private Date dataInicio;
    private Date dataEncerramento;
    private Integer horasApontadas;

}
