package com.unidac.apirest.dao;

import java.sql.SQLException;
import java.util.Collection;

public interface DAO<BEAN> {
    public boolean insere(BEAN obj) throws SQLException;
    public boolean remove(BEAN obj) throws SQLException;
    public boolean altera(BEAN obj) throws SQLException;
    public BEAN buscaID(BEAN obj) throws SQLException;
    public Collection<BEAN> lista(String criterio) throws SQLException;
}
