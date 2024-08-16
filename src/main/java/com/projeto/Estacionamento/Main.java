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

        for (int opcao = 0; opcao != 5; ) {
            System.out.format("[1]ADICIONAR CARRO \n[2]RETIRAR CARRO \n[3]ALTERAR UM DADO \n[4]EXIBIR CARROS CADASTRADOS\n[5]SAIR\n");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (Objects.equals(opcao, 1)) {
                // Adicionar carro
                Usuario u = new Usuario();

                System.out.println("Qual o nome da pessoa: ");
                u.setNome(scanner.nextLine());

                System.out.println("Qual o CPF dele(a): ");
                u.setCpf(scanner.nextLine());

                System.out.println("Qual o modelo do carro: ");
                u.setCarro(scanner.nextLine());

                System.out.println("Qual a placa do carro: ");
                u.setPlaca(scanner.nextLine());

                // Validação dos dados
                try {
                    new UsuarioDAO().validarCpf(u);
                    new UsuarioDAO().validarNome(u);
                    new UsuarioDAO().validarPlaca(u);
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro na validação: " + e.getMessage());
                    continue; // Volta para o início do loop principal
                }

                Date dataHora = new Date();
                data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
                hora = new SimpleDateFormat("HH:mm:ss").format(dataHora);
                horario = data + " " + hora;

                System.out.println(horario + "\n");
                u.setEntrada(horario);

                new UsuarioDAO().cadastraCarro(u);

            } else if (Objects.equals(opcao, 2)) {
                // Retirar carro
                Usuario u = new Usuario();

                System.out.println("Qual a PLACA do carro: ");
                u.setPlaca(scanner.nextLine());

                // Validação da Placa
                try {
                    new UsuarioDAO().validarPlaca(u);
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro na validação: " + e.getMessage());
                    continue;
                }

                Date dataHora = new Date();
                data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
                hora = new SimpleDateFormat("HH:mm:ss").format(dataHora);
                horario = data + " " + hora;

                System.out.println(horario + "\n");
                u.setSaida(horario);

                new UsuarioDAO().retirarCarro(u);
            } else if (Objects.equals(opcao, 3)) {
                // Alterar dados
                Usuario u = new Usuario();

                System.out.println("O QUE ALTERAR? ");
                System.out.println("[1]NOME \n[2]CPF \n[3]CARRO \n[4]PLACA \n[5]SAIR");
                int opcao1 = scanner.nextInt();
                scanner.nextLine();

                if (opcao1 != 5) {
                    System.out.println("Insira o CPF de quem você quer alterar : ");
                    u.setCpf(scanner.nextLine());

                    if (opcao1 == 1) {
                        u.setTrocar("nome");
                        System.out.println("INSIRA O NOVO NOME : ");
                        u.setMudar(scanner.nextLine());
                        try {
                            new UsuarioDAO().validarNome(u);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro na validação: " + e.getMessage());
                            continue;
                        }
                    } else if (opcao1 == 2) {
                        u.setTrocar("cpf");
                        System.out.println("INSIRA O NOVO CPF : ");
                        u.setMudar(scanner.nextLine());
                        try {
                            new UsuarioDAO().validarCpf(u);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro na validação: " + e.getMessage());
                            continue;
                        }
                    } else if (opcao1 == 3) {
                        u.setTrocar("carro");
                        System.out.println("INSIRA O NOVO CARRO : ");
                        u.setMudar(scanner.nextLine());
                    } else if (opcao1 == 4) {
                        u.setTrocar("placa");
                        System.out.println("INSIRA A NOVA PLACA : ");
                        u.setMudar(scanner.nextLine());
                        try {
                            new UsuarioDAO().validarPlaca(u);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro na validação: " + e.getMessage());
                            continue;
                        }
                    }
                }
            } else if (Objects.equals(opcao, 4)) {
                // Exibir carros
                for (int opcao2 = 0; opcao2 != 3; ) {
                    System.out.println("[1]EXIBIR TODOS \n[2]FAZER UMA PESQUISA \n[3]SAIR");
                    opcao2 = scanner.nextInt();
                    scanner.nextLine();

                    if (Objects.equals(opcao2, 1)) {
                        // Exibir todos os carros
                        Usuario u = new Usuario();
                        new UsuarioDAO().exibirTabela(u);
                    } else if (Objects.equals(opcao2, 2)) {
                        // Pesquisa específica
                        Usuario u = new Usuario();

                        System.out.println("[1]CPF \n[2]PLACA");
                        int opcao22 = scanner.nextInt();
                        scanner.nextLine();

                        if (Objects.equals(opcao22, 1)) {
                            u.setTrocar("cpf");
                            System.out.println("QUAL O CPF");
                            u.setMudar(scanner.nextLine());
                        } else if (Objects.equals(opcao22, 2)) {
                            u.setTrocar("placa");
                            System.out.println("QUAL A PLACA");
                            u.setMudar(scanner.nextLine());
                        }

                        new UsuarioDAO().exibirUsuario(u);
                    }
                }
            }
        }
    }
}
