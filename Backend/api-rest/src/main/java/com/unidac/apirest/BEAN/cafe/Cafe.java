package com.unidac.apirest.BEAN.cafe;

import com.unidac.apirest.BEAN.opcaoCafe.DadosOpcoes;
import com.unidac.apirest.BEAN.opcaoCafe.OpcaoCafe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cafe {
    Long id;
    LocalDate data;
    ArrayList<OpcaoCafe> opcoes;
    public Cafe(DadosCadastroCafe dados) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data = LocalDate.parse(dados.data(),formatter);
        this.opcoes = new ArrayList<OpcaoCafe>();
        //Adicionar loop do dto para a bean
        //opcoes.add(new OpcaoCafe(dados.opcoesCafe()));
        for(int i =0; i<dados.opcoesCafe().size()-1 ; i++){
            DadosOpcoes dOp = dados.opcoesCafe().get(i);
            this.opcoes.add(new OpcaoCafe(dOp));
        }
        /*
        opcoes.forEach( OpcaoCafe -> {
            OpcaoCafe = new OpcaoCafe(dados.opcoesCafe());
        });

         */
    }

    public Cafe(LocalDate data, ArrayList<OpcaoCafe> opcoes) {
        this.data = data;
        this.opcoes = opcoes;
    }
    }