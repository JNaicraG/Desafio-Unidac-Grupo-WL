package com.unidac.apirest.dao;

import com.unidac.apirest.BEAN.cafe.Cafe;
import com.unidac.apirest.BEAN.colaborador.Colaborador;
import com.unidac.apirest.BEAN.opcaoCafe.OpcaoCafe;
import com.unidac.apirest.persistencia.Banco;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class OpcaoCafeDAO implements DAO<OpcaoCafe> {

    private java.sql.PreparedStatement pst;
    private java.sql.ResultSet rs;
    private OpcaoCafe opcaoCafe;

    @Override
    public boolean insere(OpcaoCafe obj) throws SQLException {
        //Inserção no café
        String sql = "INSERT INTO opcaocafe (id_cafe, id_colaborador, opcao, levou) "
                + " VALUES (?, ?, ?, ?)";
        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);
        pst.setLong(1, obj.getIdCafe());
        pst.setLong(2,  obj.getIdColaborador());
        pst.setString(3, obj.getOpcao());
        pst.setBoolean(4, obj.getLevou());
        int res = pst.executeUpdate();

        //Inserir no OpcaoCafe
        Banco.desconectar();
        return res!=0;
    }

    @Override
    public boolean remove(OpcaoCafe obj) throws SQLException {
        return false;
    }

    @Override
    public boolean altera(OpcaoCafe obj) throws SQLException {
        String sql = "UPDATE opcaocafe SET levou=? "
                + "WHERE id_cafe = ?";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);
        pst.setBoolean(1,obj.getLevou());
        pst.setLong(2,obj.getIdCafe());
        int res = pst.executeUpdate();
        Banco.desconectar();


        return res !=0;
    }

    @Override
    public OpcaoCafe buscaID(OpcaoCafe obj) throws SQLException {
       /* String sql = "SELECT * FROM opcaocafe " +
                "WHERE id_cafe=?";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);
        pst.setLong(1, obj.getIdCafe());
        rs = pst.executeQuery();
        if(rs.next()){
            opcaoCafe = new OpcaoCafe();
            opcaoCafe.s(rs.getString("nome"));
            opcaoCafe.setCpf(rs.getString("cpf"));
            opcaoCafe.setId(rs.getLong("id"));
        } else {
            opcaoCafe = null;
        }

        Banco.desconectar();

        return opcaoCafe;*/
        return null;
    }

    @Override
    public Collection<OpcaoCafe> lista(String criterio) throws SQLException {
        ArrayList<OpcaoCafe> lista = new ArrayList<>();
        String sql = "SELECT * FROM opcaocafe ";
        if (criterio != null && criterio.length() > 0) { //Isso precisa?
            sql += " WHERE " + criterio;
        }
        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);

        rs = pst.executeQuery();

        while (rs.next()) {
            //criar o objeto
            opcaoCafe = new OpcaoCafe();
            //mover os dados do resultSet para o objeto proprietário
            opcaoCafe.setIdCafe (rs.getLong("id_cafe"));
            opcaoCafe.setIdColaborador (rs.getLong("id_colaborador"));
            opcaoCafe.setOpcao (rs.getString("opcao"));
            opcaoCafe.setLevou (rs.getBoolean("levou"));
            lista.add(opcaoCafe);
        }

        Banco.desconectar();

        return lista;
    }

}
