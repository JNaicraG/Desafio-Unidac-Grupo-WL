package com.unidac.apirest.dao;

import com.unidac.apirest.BEAN.Colaborador;
import com.unidac.apirest.persistencia.Banco;

import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Collection;

public class ColaboradorDAO implements DAO<Colaborador>{

    private java.sql.PreparedStatement pst;
    private java.sql.ResultSet rs;
    private Colaborador colaborador;

    @Override
    public boolean insere(Colaborador obj) throws SQLException {
        String sql = "INSERT INTO Colaboradores (Nome, CPF, Data) "
                + " VALUES (?, ?, ?)";
        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCpf());
        pst.setDate(3, java.sql.Date.valueOf(obj.getData()));

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
        return null;
    }
}
