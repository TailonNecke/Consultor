package projeto.consultor.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import projeto.consultor.domain.ValidationGroups;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
@Entity
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long idCard;

    @NotBlank
    String secao;

    @NotNull
    Long codProjeto;

    @NotBlank
    String descProjeto;

    @NotBlank
    String status;

    @NotNull
    Date dataInicio;

    @NotNull
    Date dataEncerramento;

    @NotNull
    Integer horasApontadas;
}
