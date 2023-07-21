package com.unidac.apirest.BEAN.opcaoCafe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
public class OpcaoCafe {
    Long idCafe;
    Long idColaborador;
    String opcao;
    Boolean levou;

    public OpcaoCafe(DadosOpcoes dadosOpcoes) {
        this.idColaborador = dadosOpcoes.idColaborador();
        this.opcao = dadosOpcoes.opcao();
        this.levou = false;
    }
    public OpcaoCafe(Long idCafe, DadosOpcoes opcao) {
        this.idCafe = idCafe;
        this.idColaborador = opcao.idColaborador();
        this.opcao = opcao.opcao();
        this.levou = opcao.levou();
    }
}
