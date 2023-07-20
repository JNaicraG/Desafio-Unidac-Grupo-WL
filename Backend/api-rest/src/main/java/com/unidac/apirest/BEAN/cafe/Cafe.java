package com.unidac.apirest.BEAN.cafe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cafe {
    Long id;
    LocalDate data;
    public Cafe(DadosCadastroCafe dados) {
    }
}
