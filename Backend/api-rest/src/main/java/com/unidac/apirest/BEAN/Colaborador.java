package com.unidac.apirest.BEAN;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of)
public class Colaborador {
    String nome;
    String cpf;
    Date data;
}
