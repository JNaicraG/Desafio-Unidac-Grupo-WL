package com.unidac.apirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unidac.apirest.BEAN.Colaborador;
import com.unidac.apirest.colaborador.DadosAlterarColaborador;
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

    @GetMapping("/{id}")
    public Colaborador BuscaId(@PathVariable Long id) throws SQLException {
        Colaborador colab = new Colaborador();
        colab.setId(id);
        return dao.buscaID(colab);
    }

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
            if (dao.insere(new Colaborador(dados))) {
                return ResponseEntity.ok("Sucesso!");
            }
            return ResponseEntity.badRequest().body("Erro no cadastro!");
        } catch (SQLException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeletarColaborador(@RequestBody @PathVariable Long id ){
        try {
            Colaborador colab = new Colaborador();
            colab.setId(id);
            if (dao.remove(colab)) {
                return ResponseEntity.ok("Sucesso!");
            }
            return ResponseEntity.badRequest().body("Não excluído!");

        } catch (SQLException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> AlterarColaborador(@RequestBody @Valid DadosAlterarColaborador dados){
        try{
            if(dao.altera(new Colaborador(dados))){
                return ResponseEntity.ok("Sucesso!");
            }
            return ResponseEntity.badRequest().body("Não Alterado!");
        } catch (SQLException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
