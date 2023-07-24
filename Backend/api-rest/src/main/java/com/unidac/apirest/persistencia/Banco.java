package com.unidac.apirest.persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    public static String bancoDados, usuario, senha, servidor;
    public static int porta;

    //variavel de conexao
    public static java.sql.Connection conexao = null;

    //define valores padrão
    static { //"""""cobstrutor"""""" static, igual o Start() no Unity
        //mysql e mariaDB
        /*
        bancoDados = "desafio_unidac";
        usuario = "root";
        senha = "4474";
        servidor = "localhost";
        porta = 3306;
        */
        bancoDados = "railway";
        usuario = "root";
        senha = "1E1n6gC1FNBWjdEnXWuU";
        servidor = "containers-us-west-152.railway.app";
        porta = 7734;
    }

    /**
     * conectar
     * @throws SQLException
     */
    public static void conectar() throws SQLException{

        String url = "jdbc:mysql://" + servidor +
                ":" + porta + "/" + bancoDados;

        conexao = DriverManager.getConnection(url,
                usuario, senha);
    }

    /**
     * desconectar
     * @throws SQLException
     */
    public static void desconectar()throws SQLException{
        conexao.close();
    }

    /**
     * retorna conexao com sucesso
     * @return
     * @throws SQLException
     */
    public static java.sql.Connection obterConexao()throws SQLException {
        if(conexao == null)
            throw new SQLException("Conexão Fechada");
        else
            return conexao;
    }
}
