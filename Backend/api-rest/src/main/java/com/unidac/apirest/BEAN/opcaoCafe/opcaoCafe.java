package com.unidac.apirest.BEAN.opcaoCafe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
public class opcaoCafe {
    Long idCafe;
    Long idColaborador;
    String opcao;

    public opcaoCafe(DadosOpcoes dadosOpcoes) {
        this.idColaborador = dadosOpcoes.idColaborador();
        this.opcao = dadosOpcoes.opcao();
    }
}
