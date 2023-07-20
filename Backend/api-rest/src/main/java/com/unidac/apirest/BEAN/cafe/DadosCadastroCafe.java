package com.unidac.apirest.BEAN.cafe;

import com.unidac.apirest.BEAN.opcaoCafe.DadosOpcoes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public record DadosCadastroCafe(
        @NotBlank
        String data,
        @NotNull
        DadosOpcoes opcoesCafe
) {
}
