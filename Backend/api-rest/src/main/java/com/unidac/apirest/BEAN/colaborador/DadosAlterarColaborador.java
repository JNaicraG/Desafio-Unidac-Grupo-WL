package com.unidac.apirest.BEAN.colaborador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosAlterarColaborador(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String cpf
) {
}
