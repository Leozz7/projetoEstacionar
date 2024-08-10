package com.projeto.Estacionamento;

import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public void cadastraCarro(Usuario u) {
        String sql = "INSERT INTO carros (NOME, CPF , CARRO , PLACA ,  ENTRADA) VALUES (? , ? , ? , ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getNome());
            ps.setString(2, u.getCpf());
            ps.setString(3, u.getCarro());
            ps.setString(4, u.getPlaca());
            ps.setString(5, u.getEntrada());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retirarCarro(Usuario u) {
        String sql = "UPDATE carros SET saida = ? WHERE placa = ? AND saida IS NULL";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getSaida());
            ps.setString(2, u.getPlaca());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarDado(Usuario u) {
        String sql = "UPDATE carros SET " + u.getTrocar() + " = ? WHERE cpf = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, u.getMudar());
            ps.setString(2, u.getCpf());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}