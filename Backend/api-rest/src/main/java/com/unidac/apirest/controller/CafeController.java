package com.unidac.apirest.controller;

import com.unidac.apirest.BEAN.cafe.Cafe;
import com.unidac.apirest.BEAN.cafe.DadosCadastroCafe;
import com.unidac.apirest.dao.CafeDAO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/cafe")
public class CafeController {
    CafeDAO dao = new CafeDAO();

    @PostMapping
    public ResponseEntity<String> CadastrarCafe(@RequestBody@Valid DadosCadastroCafe dados){
        try{
            if(dao.insere(new Cafe(dados))){
                //Pegar id para integrar a opcaoCafe
                return ResponseEntity.ok("Sucesso");
            }
            return ResponseEntity.badRequest().body("Erro ao inserir dados");
        } catch (SQLException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
