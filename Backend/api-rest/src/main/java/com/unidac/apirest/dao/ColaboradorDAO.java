package com.unidac.apirest.dao;

import com.unidac.apirest.BEAN.Colaborador;
import com.unidac.apirest.persistencia.Banco;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class ColaboradorDAO implements DAO<Colaborador>{

    private java.sql.PreparedStatement pst;
    private java.sql.ResultSet rs;
    private Colaborador colaborador;

    @Override
    public boolean insere(Colaborador obj) throws SQLException {
        String sql = "INSERT INTO Colaboradores (nome, cpf) "
                + " VALUES (?, ?)";
        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCpf());
        //pst.setDate(3, java.sql.Date.valueOf(obj.getData()));

        int res = pst.executeUpdate();
        Banco.desconectar();

        return res!=0;
    }

    @Override
    public boolean remove(Colaborador obj) throws SQLException {
        return false;
    }

    @Override
    public boolean altera(Colaborador obj) throws SQLException {
        return false;
    }

    @Override
    public Colaborador buscaID(Colaborador obj) throws SQLException {
        return null;
    }

    @Override
    public Collection<Colaborador> lista(String criterio) throws SQLException {
        ArrayList<Colaborador> lista = new ArrayList<>();
        String sql = "SELECT * FROM colaboradores ";
        if (criterio != null && criterio.length() > 0) { //Isso precisa?
            sql += " WHERE " + criterio;
        }
        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {
            //criar o objeto
            colaborador = new Colaborador();
            //mover os dados do resultSet para o objeto proprietário
            colaborador.setId(rs.getLong("id"));
            colaborador.setNome(rs.getString("nome"));
            colaborador.setCpf(rs.getString("cpf"));

            //Date date = rs.getDate("data");
            //colaborador.setData(date.toLocalDate());
            lista.add(colaborador);
        }

        Banco.desconectar();

        return lista;
    }
}
