package projeto.consultor.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.internal.engine.groups.ValidationOrderGenerator;
import projeto.consultor.domain.ValidationGroups;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static lombok.AccessLevel.PRIVATE;

//Regra de Negócio
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
@Entity
public class Consultor {

    @NotNull(groups = ValidationGroups.ValidId.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long id_consultor;

    @NotNull
    Long idFornecedor;

    @NotBlank
    String nome;

    @NotBlank
    @Email
    String email;

    @NotBlank
    @Size(min = 14, max = 16)
    String telefone;

    @NotBlank
    String atuacao;

    @NotNull
    Double valor_hora;

}
