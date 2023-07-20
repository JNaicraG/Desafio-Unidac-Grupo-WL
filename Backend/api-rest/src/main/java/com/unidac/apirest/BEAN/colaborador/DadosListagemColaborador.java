package com.unidac.apirest.BEAN.colaborador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosListagemColaborador(
        String nome,
        String cpf
) {
}
