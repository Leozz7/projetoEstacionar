package com.projeto.Estacionamento;

import entity.Usuario;
import java.sql.*;

/*
 * Classe de acesso a dados para a entidade Usuario.
 * Fornece métodos para operações CRUD no banco de dados.
 */

public class UsuarioDAO {
    /*
     * Cadastra um novo carro no banco de dados.
     */
    public void cadastraCarro(Usuario u) {
        String sql = "INSERT INTO carros (NOME, CPF , CARRO , PLACA , ENTRADA) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getNome());
            ps.setString(2, u.getCpf());
            ps.setString(3, u.getCarro());
            ps.setString(4, u.getPlaca());
            ps.setString(5, u.getEntrada());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar carro: " + e.getMessage());
        }
    }
    /*
    * Validar se oa dados inseridos pelo usuário estão nas normas.
     */
    public void validarNome(Usuario u) {
        if (u.getNome() == null || u.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio \n");
        }
    }
    public void validarCpf(Usuario u) {
        if (u.getCpf() == null || u.getCpf().length() != 14) {
            throw new IllegalArgumentException("CPF deve ter o formato 000.000.000-00\n");
        }
    }
    public void validarPlaca(Usuario u) {
        if (u.getPlaca() == null || !u.getPlaca().matches("[A-Z]{3}\\d{4}")) {
            throw new IllegalArgumentException("Placa deve ter o formato XXX0000 \n");
        }
    }
    /*
     * Retira um carro do banco de dados com base na placa.
     */
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
    /*
     * Altera um dado de um carro no banco de dados.
     */

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
    /*
     * Exibe todos os carros cadastrados no banco de dados.
     */
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
    /*
     * Exibe um carro específico com base no CPF ou placa.
     */
    public void exibirUsuario(Usuario u) {
        String sql = "SELECT * FROM CARROS WHERE " + u.getTrocar() + " = ?" ;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getMudar());

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String carro = rs.getString("carro");
                    String placa = rs.getString("placa");
                    String entrada = rs.getString("entrada");
                    String saida = rs.getString("saida");

                    System.out.println(id + " | " + nome + " | " + cpf + " | " + carro + " | " + placa + " | ENTRADA :" + entrada + " | SAÍDA :" + saida + " | ");
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}