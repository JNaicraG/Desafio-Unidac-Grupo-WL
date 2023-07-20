package com.unidac.apirest.dao;

import com.unidac.apirest.BEAN.colaborador.Colaborador;
import com.unidac.apirest.persistencia.Banco;

import java.sql.SQLException;
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
        String sql = "DELETE FROM colaboradores WHERE id = ?";
        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);
        pst.setLong(1,obj.getId());
        int res = pst.executeUpdate();
        Banco.desconectar();

        return res!= 0;
    }

    @Override
    public boolean altera(Colaborador obj) throws SQLException {
        String sql = "UPDATE colaboradores SET nome=?, cpf =? "
                    + "WHERE id = ?";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);
        pst.setString(1,obj.getNome());
        pst.setString(2,obj.getCpf());
        pst.setLong(3,obj.getId());
        int res = pst.executeUpdate();
        Banco.desconectar();


        return res !=0;
    }

    @Override
    public Colaborador buscaID(Colaborador obj) throws SQLException {
        String sql = "SELECT * FROM colaboradores " +
                        "WHERE id=?";

        Banco.conectar();
        pst = Banco.obterConexao().prepareStatement(sql);
        pst.setLong(1, obj.getId());
        rs = pst.executeQuery();
        if(rs.next()){
            colaborador = new Colaborador();
            colaborador.setNome(rs.getString("nome"));
            colaborador.setCpf(rs.getString("cpf"));
            colaborador.setId(rs.getLong("id"));
        } else {
            colaborador = null;
        }

        Banco.desconectar();

        return colaborador;
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
