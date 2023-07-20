package com.unidac.apirest.colaborador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record DadosCadastroColaborador(
    @NotBlank
   String nome,
    @NotBlank
    String cpf,
    @NotEmpty
    @NotNull
    LocalDate data
    ){
}

