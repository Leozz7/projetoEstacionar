package com.projeto.Estacionamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conn;

    public static Connection getConexao() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estacionamento", "root", "");
            } catch (Exception e) {
                e.printStackTrace();
                throw new SQLException("Erro ao conectar com o banco de dados");
            }
        }
        return conn;
    }
}
//com.mysql.cj.jdbc.Driver
//"jdbc:mysql://localhost:3306/estacionamento", "root", ""

