package com.unidac.apirest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unidac.apirest.BEAN.cafe.Cafe;
import com.unidac.apirest.BEAN.cafe.DadosCadastroCafe;
import com.unidac.apirest.BEAN.opcaoCafe.DadosOpcoes;
import com.unidac.apirest.BEAN.opcaoCafe.OpcaoCafe;
import com.unidac.apirest.dao.CafeDAO;
import com.unidac.apirest.dao.OpcaoCafeDAO;
import jakarta.validation.Valid;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.asm.TypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


@RestController
@RequestMapping("/cafe")
public class CafeController {
    CafeDAO dao = new CafeDAO();
    OpcaoCafeDAO opcaoDAO = new OpcaoCafeDAO();

    @PostMapping
    public ResponseEntity<Boolean> CadastrarCafe(@RequestBody@Valid String json) throws SQLException, ParseException, JsonProcessingException {
        //Mapeamento de dados e do Array Json
        System.out.println("Json: " + json);
        Cafe cafe = ParseJSON(json);


        System.out.println(("Convertido"));
        System.out.println(cafe.getData() + " aaaaa " + cafe.getOpcoesCafe());
        //DadosCadastroCafe dados
        if (dao.insere(cafe)) {
            //Pegar id para integrar a OpcaoCafe
            ArrayList<Cafe> lista = (ArrayList<Cafe>) dao.lista("");

            Cafe obj = lista.get(lista.size()-1);
            cafe.getOpcoesCafe().forEach(opcao ->{
                System.out.println("Cafe: " + opcao);
                opcao.setIdCafe(obj.getId());
                try {
                    Boolean res = opcaoDAO.insere(opcao);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }

    @GetMapping
    public Collection<Cafe> ListarCafes() throws SQLException {
        Collection<Cafe> cafes= dao.lista("");
        cafes.forEach(cafe -> {
            Collection<OpcaoCafe> opCafes = null;
            try {
                opCafes = opcaoDAO.lista("id_cafe=" + cafe.getId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            cafe.setOpcoesCafe((ArrayList<OpcaoCafe>) opCafes);
        });
        return cafes;
    }

    @PatchMapping
    public ResponseEntity<Boolean> AlterarCafeLevou(@RequestBody@Valid OpcaoCafe dados) throws SQLException {
        System.out.println(dados);
        if(opcaoDAO.altera(dados)){
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }

    private Cafe ParseJSON(String json) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        DadosCadastroCafe dados = mapper.readValue(json, DadosCadastroCafe.class);
        dados.opcoesCafe().add(new DadosOpcoes(2L,"Abacaxi",false));
        System.out.println("DTO " + dados.opcoesCafe());

        return new Cafe(dados);


    }

}
