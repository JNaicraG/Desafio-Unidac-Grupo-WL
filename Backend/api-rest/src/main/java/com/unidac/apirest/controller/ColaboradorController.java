package com.unidac.apirest.controller;

import com.unidac.apirest.colaborador.DadosCadastroColaborador;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    @PostMapping
    public void Cadastrar(@RequestBody @Valid DadosCadastroColaborador dados){
        //Cadastrar
    }

}
