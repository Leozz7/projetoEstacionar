package com.projeto.Estacionamento;

import entity.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String data;
        String hora;
        String horario;

        for (int opcao = 0; opcao != 3; ) {
            {
                System.out.format("[1]Adiciona Carro \n[2]Retirar Carro \n[3] Sair\n");
                opcao = scanner.nextInt();
                scanner.nextLine();


                if (Objects.equals(opcao, 1)) {


                    Usuario u = new Usuario();

                    System.out.println("Qual o nome da pessoa: ");
                    u.setNome(scanner.nextLine());

                    System.out.println("Qual o CPF dele(a): ");
                    u.setCpf(scanner.nextLine());

                    System.out.println("Qual o modelo do carro: ");
                    u.setCarro(scanner.nextLine());

                    Date dataHora = new Date();

                    data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
                    hora = new SimpleDateFormat("HH:mm:ss").format(dataHora);

                    horario = data + " " + hora;

                    System.out.println(horario);

                    u.setEntrada(horario);

                    new UsuarioDAO().cadastraCarro(u);

                } else if (Objects.equals(opcao, 2)) {
                    Usuario u = new Usuario();

                    System.out.println("Qual o nome da pessoa: ");

                    u.setNome(scanner.nextLine());

                    Date dataHora = new Date();


                    data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
                    hora = new SimpleDateFormat("HH:mm:ss").format(dataHora);

                    horario = data + " " + hora;

                    System.out.println(horario);

                    u.setSaida(horario);

                    new UsuarioDAO().retirarCarro(u);
                }
            }
        }
    }
}