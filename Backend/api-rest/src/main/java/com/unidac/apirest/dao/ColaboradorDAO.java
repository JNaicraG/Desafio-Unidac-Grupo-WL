package com.unidac.apirest.dao;

import com.unidac.apirest.BEAN.Colaborador;

import java.sql.SQLException;
import java.util.Collection;

public class ColaboradorDAO implements DAO<Colaborador>{

    @Override
    public boolean insere(Colaborador obj) throws SQLException {
        return false;
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
