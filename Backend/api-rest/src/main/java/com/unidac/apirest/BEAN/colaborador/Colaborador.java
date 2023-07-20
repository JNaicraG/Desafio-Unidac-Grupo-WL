package com.unidac.apirest.BEAN.colaborador;

import com.unidac.apirest.BEAN.colaborador.DadosAlterarColaborador;
import com.unidac.apirest.BEAN.colaborador.DadosCadastroColaborador;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Colaborador {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;

    public Colaborador(DadosCadastroColaborador dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
    }

    public Colaborador(DadosAlterarColaborador dados){
        this.id = dados.id();
        this.nome = dados.nome();
        this.cpf = dados.cpf();
    }
}
