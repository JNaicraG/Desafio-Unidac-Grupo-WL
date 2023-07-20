package com.unidac.apirest.BEAN;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unidac.apirest.colaborador.DadosCadastroColaborador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Colaborador {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;

    public Colaborador(DadosCadastroColaborador dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
    }

}
