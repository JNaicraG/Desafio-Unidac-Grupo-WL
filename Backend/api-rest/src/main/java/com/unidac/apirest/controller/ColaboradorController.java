package com.unidac.apirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unidac.apirest.BEAN.Colaborador;
import com.unidac.apirest.colaborador.DadosCadastroColaborador;
import com.unidac.apirest.dao.ColaboradorDAO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    private ColaboradorDAO dao = new ColaboradorDAO();

    @GetMapping
    public Collection<Colaborador> ListarColaboradores(){
        try {
            return dao.lista("");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping
    public ResponseEntity<String> CadastrarColaborador(@RequestBody @Valid DadosCadastroColaborador dados){
        /*
        ObjectMapper objectMapper = new ObjectMapper();
        DadosCadastroColaborador dados = objectMapper.readValue(jsonString, DadosCadastroColaborador.class);

         */
        /*
        dados.nome() = jsonColaborador.nome();
        dados.cpf() = jsonColaborador.cpf();
        dados.data() = LocalDate.parse(jsonColaborador.data())
        */

        //Cadastrar
        try {
            System.out.println("AAAAAAAA");
            System.out.println(dados);
            if (dao.insere(new Colaborador(dados))) {
                System.out.println("Dados inseridos?");
                return ResponseEntity.ok("Sucesso!");
            }
            return ResponseEntity.badRequest().body("Erro no cadastro!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    /*
    @PutMapping
    public ResponseEntity<String> AtualizarColaborador(){
        return ResponseEntity.ok("Sucesso");
    }
     */

}
