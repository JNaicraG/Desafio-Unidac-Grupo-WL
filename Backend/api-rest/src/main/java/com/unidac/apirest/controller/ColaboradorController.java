package com.unidac.apirest.controller;

import com.unidac.apirest.BEAN.colaborador.Colaborador;
import com.unidac.apirest.BEAN.colaborador.DadosAlterarColaborador;
import com.unidac.apirest.BEAN.colaborador.DadosCadastroColaborador;
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
    public Collection<Colaborador> ListarColaboradores() throws SQLException {
        return dao.lista("");
        /*
        try {
            return dao.lista("");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */
    }
    @PostMapping
    public ResponseEntity<Boolean> CadastrarColaborador(@RequestBody @Valid DadosCadastroColaborador dados) throws SQLException {
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
        if (dao.insere(new Colaborador(dados))) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> DeletarColaborador(@RequestBody @PathVariable Long id )  throws SQLException {

            Colaborador colab = new Colaborador();
            colab.setId(id);
            if (dao.remove(colab)) {
                return ResponseEntity.ok(true);
            }
            return ResponseEntity.badRequest().body(false);
    }

    @PutMapping
    public ResponseEntity<Boolean> AlterarColaborador(@RequestBody @Valid DadosAlterarColaborador dados) throws SQLException {

        if(dao.altera(new Colaborador(dados))){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);

        /*
        try{
            if(dao.altera(new Colaborador(dados))){
                return ResponseEntity.ok("Sucesso!");
            }
            return ResponseEntity.badRequest().body("Não Alterado!");
        } catch (SQLException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

         */
    }

}
