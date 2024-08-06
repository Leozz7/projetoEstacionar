package com.projeto.Estacionamento;

import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void cadastraCarro(Usuario u) {
        String sql = "INSERT INTO carros (NOME, CPF ,CARRO, ENTRADA) VALUES (? , ? , ? , ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getNome());
            ps.setString(2, u.getCpf());
            ps.setString(3, u.getCarro());
            ps.setString(4, u.getEntrada());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void verificar(Usuario u) {
        String sql = "SELECT COUNT(NOME) FROM carros WHERE nome = ?";

        try (Connection conn = Conexao.getConexao();
         PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getNome());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retirarCarro(Usuario u) {
        String sql = "UPDATE carros SET saida = ? WHERE nome = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getSaida());
            ps.setString(2, u.getNome());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}