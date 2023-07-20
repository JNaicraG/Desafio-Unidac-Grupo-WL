package com.unidac.apirest.BEAN.cafe;

import com.unidac.apirest.BEAN.colaborador.Colaborador;
import com.unidac.apirest.BEAN.opcaoCafe.opcaoCafe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cafe {
    Long id;
    LocalDate data;
    Collection<opcaoCafe> opcoes;
    public Cafe(DadosCadastroCafe dados) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data = LocalDate.parse(dados.data(),formatter);

        //Adicionar loop do dto para a bean
        opcoes.add(new opcaoCafe(dados.opcoesCafe());
        /*
        opcoes.forEach( opcaoCafe -> {
            opcaoCafe = new opcaoCafe(dados.opcoesCafe());
        });

         */
    }
}
