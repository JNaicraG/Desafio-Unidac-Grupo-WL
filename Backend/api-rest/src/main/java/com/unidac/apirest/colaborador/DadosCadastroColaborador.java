package com.unidac.apirest.colaborador;

import java.util.Date;

public record DadosCadastroColaborador(
    String nome,
    String cpf,
    Date data
    ){
}
