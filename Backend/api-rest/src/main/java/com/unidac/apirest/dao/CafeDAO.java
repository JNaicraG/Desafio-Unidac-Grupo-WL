package com.unidac.apirest.dao;

import com.unidac.apirest.BEAN.cafe.Cafe;
import com.unidac.apirest.persistencia.Banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class CafeDAO implements DAO<Cafe>{
    private java.sql.PreparedStatement pst;
    private java.sql.ResultSet rs;
    private Cafe cafe;
    @Override
    public boolean insere(Cafe obj) throws SQLException {
        //Inserção no café
        String sql = "INSERT INTO cafe (data) "
                + " VALUES (?)";
        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setDate(1, java.sql.Date.valueOf(obj.getData()));
        int res = pst.executeUpdate();

        //Pegar ID gerado
        rs = pst.getGeneratedKeys();
        if(rs.next()){
            obj.setId(rs.getLong(1));
        }

        //Inserir no opcaoCafe


        Banco.desconectar();

        return res!=0;
    }

    @Override
    public boolean remove(Cafe obj) throws SQLException {
        return false;
    }

    @Override
    public boolean altera(Cafe obj) throws SQLException {
        return false;
    }

    @Override
    public Cafe buscaID(Cafe obj) throws SQLException {
        return null;
    }

    @Override
    public Collection<Cafe> lista(String criterio) throws SQLException {
        return null;
    }
}
