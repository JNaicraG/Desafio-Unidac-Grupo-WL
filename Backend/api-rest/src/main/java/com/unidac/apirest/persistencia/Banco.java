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

        bancoDados = "desafio_unidac";
        usuario = "root";
        senha = "4474";
        servidor = "localhost";
        porta = 3306;
    }

    /**
     * conectar
     * @throws SQLException
     */
    public static void conectar() throws SQLException{
        // String url = " mysql://root:AdShHRqNUGVrzv25lQ8G@containers-us-west-91.railway.app:6814/railway";
        String url = "jdbc:mariadb://" + servidor +
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
