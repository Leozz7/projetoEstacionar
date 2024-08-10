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

        for (int opcao = 0; opcao != 4; ) {
            {
                System.out.format("[1]ADICIONAR CARRO \n[2]RETIRAR CARRO \n[3]ALTERAR UM DADO \n[4]SAIR\n");
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

                    System.out.println("Qual a placa do carro: ");
                    u.setPlaca(scanner.nextLine());

                    Date dataHora = new Date();

                    data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
                    hora = new SimpleDateFormat("HH:mm:ss").format(dataHora);

                    horario = data + " " + hora;

                    System.out.println(horario + "\n");

                    u.setEntrada(horario);

                    new UsuarioDAO().cadastraCarro(u);

                } else if (Objects.equals(opcao, 2)) {
                    Usuario u = new Usuario();

                    System.out.println("Qual a PLACA do carro: ");

                    u.setPlaca(scanner.nextLine());

                    Date dataHora = new Date();

                    data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
                    hora = new SimpleDateFormat("HH:mm:ss").format(dataHora);

                    horario = data + " " + hora;

                    System.out.println(horario + "\n");

                    u.setSaida(horario);

                    new UsuarioDAO().retirarCarro(u);
                } else if (Objects.equals(opcao, 3)) {
                    Usuario u = new Usuario();

                    System.out.println("Insira o CPF de quem você quer alterar : ");
                    u.setCpf(scanner.next());

                    System.out.println("[1]NOME \n[2]CPF \n[3]CARRO \n[4]PLACA \n[5]SAIR");
                    int opcao1 = scanner.nextInt();
                    scanner.nextLine();

                    if (opcao1 == 1) {
                        u.setTrocar("nome");
                        System.out.println("INSIRA O NOVO NOME : ");
                        u.setMudar(scanner.nextLine());
                    } else if (opcao1 == 2) {
                        u.setTrocar("cpf");
                        System.out.println("INSIRA O NOVO CPF : ");
                        u.setMudar(scanner.nextLine());
                    } else if (opcao1 == 3) {
                        u.setTrocar("carro");
                        System.out.println("INSIRA O NOVO CARRO : ");
                        u.setMudar(scanner.nextLine());
                    } else if (opcao1 == 4) {
                        u.setTrocar("placa");
                        System.out.println("INSIRA A NOVA PLACA : ");
                        u.setMudar(scanner.nextLine());
                    }

                    Date dataHora = new Date();
                    data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
                    hora = new SimpleDateFormat("HH:mm:ss").format(dataHora);

                    horario = data + " " + hora;

                    System.out.println(horario + "\n");

                    new UsuarioDAO().alterarDado(u);
                }
            }
        }
    }
}