package com.unidac.apirest.BEAN.cafe;

import com.unidac.apirest.BEAN.opcaoCafe.DadosOpcoes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public record DadosCadastroCafe(
        @NotBlank
        String data,
        @NotNull
        ArrayList<DadosOpcoes> opcoesCafe
) {
}

