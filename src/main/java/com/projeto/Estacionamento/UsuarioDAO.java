package com.projeto.Estacionamento;

import entity.Usuario;

import java.sql.*;

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

    public void exibirTabela(Usuario u) {
        String sql = "SELECT * FROM CARROS";
        try (Connection conn = Conexao.getConexao();
             Statement ps = conn.createStatement();
             ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String carro = rs.getString("carro");
                String placa = rs.getString("placa");
                String entrada = rs.getString("entrada");
                String saida = rs.getString("saida");

                System.out.println(id + " | " + nome + " | " + cpf + " | " + carro + " | " +  placa + " | ENTRADA :" + entrada + " | SAÍDA :" +saida + " | ");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}