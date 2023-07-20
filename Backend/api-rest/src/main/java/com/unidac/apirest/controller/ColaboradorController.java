package com.unidac.apirest.controller;

import com.unidac.apirest.BEAN.Colaborador;
import com.unidac.apirest.colaborador.DadosCadastroColaborador;
import com.unidac.apirest.dao.ColaboradorDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    private ColaboradorDAO dao;
    @PostMapping
    public ResponseEntity<String> Cadastrar(@RequestBody @Valid DadosCadastroColaborador dados){
        //Cadastrar
        try {
            if (dao.insere(new Colaborador(dados))) {
                return ResponseEntity.ok("Sucesso!");
            }
            return ResponseEntity.badRequest().body("Erro no cadastro!");
        } catch (SQLException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @PutMapping
    public ResponseEntity<String> AtualizarColaborador(){
        return ResponseEntity.ok("Sucesso");
    }

}
