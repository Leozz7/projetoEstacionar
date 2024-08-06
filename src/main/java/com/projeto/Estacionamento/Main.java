package com.projeto.Estacionamento;

import entity.Usuario;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class adicionarCarro {
    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();
        Scanner scanner = new Scanner(System.in);
        Usuario u = new Usuario();
        String data;
        String hora;
        String nome;
        String carro;
        String horario;
        String cpf;

        System.out.println("Qual nome da pessoa: ");
        nome = scanner.nextLine();
        u.setNome(nome);

        System.out.println("Qual o CPF dele : ");
        cpf = scanner.nextLine();
        u.setCpf(cpf);

        System.out.println("Qual o modelo do carro: ");
        carro = scanner.nextLine();
        u.setCarro(carro);

        Date dataHora = new Date();

        data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
        hora = new SimpleDateFormat("HH:mm:ss").format(dataHora);

        horario = data + " " + hora;

        System.out.println(horario);

        u.setHorario(horario);

        new UsuarioDAO().cadastraCarro(u);
    }
}