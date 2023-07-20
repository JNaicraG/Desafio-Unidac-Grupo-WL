package com.unidac.apirest.BEAN.colaborador;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Date;

public record DadosCadastroColaborador(
    @NotBlank
   String nome,
    @NotBlank@Pattern(regexp = "\\d{11}")
    String cpf
    ){
}

