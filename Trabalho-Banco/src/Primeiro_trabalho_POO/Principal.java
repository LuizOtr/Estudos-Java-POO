package Primeiro_trabalho_POO;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Banco banco = new Banco("Banco do Bairro");
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("===== SISTEMA BANCÁRIO =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Criar conta");
            System.out.println("4 - Listar contas");
            System.out.println("5 - Realizar depósito");
            System.out.println("6 - Realizar saque");
            System.out.println("7 - Exibir extrato");
            System.out.println("8 - Transferir entre contas");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {

                case 1: {
                    System.out.println("Nome do cliente: ");
                    String nome = leitor.nextLine();
                    System.out.println("CPF do cliente: ");
                    String cpf = leitor.nextLine();

                    if (nome.equals("") || cpf.equals("")) {
                        System.out.println("Nome e CPF devem ser informados.");
                    } else {
                        int id = banco.cadastrarCliente(nome, cpf);
                        System.out.println("Cliente cadastrado com sucesso! ID: " + id);
                    }
                    break;
                }

                case 2: {
                    banco.listarClientes();
                    break;
                }

                case 3: {
                    System.out.println("ID do cliente: ");
                    int id = leitor.nextInt();
                    leitor.nextLine();

                    int numero = banco.criarConta(id);
                    if (numero == -1) {
                        System.out.println("Cliente não encontrado. A conta não foi criada.");
                    } else {
                        System.out.println("Conta " + numero + " criada com sucesso!");
                    }
                    break;
                }

                case 4: {
                    banco.listarContas();
                    break;
                }

                case 5: {
                    System.out.println("Número da conta: ");
                    int numero = leitor.nextInt();
                    System.out.println("Valor do depósito: ");
                    double valor = leitor.nextDouble();
                    leitor.nextLine();

                    if (banco.depositar(numero, valor)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Não foi possível depositar. Verifique a conta e o valor informado.");
                    }
                    break;
                }

                case 6: {
                    System.out.println("Número da conta: ");
                    int numero = leitor.nextInt();
                    System.out.println("Valor do saque: ");
                    double valor = leitor.nextDouble();
                    leitor.nextLine();

                    if (banco.sacar(numero, valor)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Não foi possível sacar. Verifique a conta, o valor e o saldo disponível.");
                    }
                    break;
                }

                case 7: {
                    System.out.println("Número da conta: ");
                    int numero = leitor.nextInt();
                    leitor.nextLine();

                    if (banco.exibirExtrato(numero) == false) {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                }

                case 8: {
                    System.out.println("Número da conta de origem: ");
                    int origem = leitor.nextInt();
                    System.out.println("Número da conta de destino: ");
                    int destino = leitor.nextInt();
                    System.out.println("Valor da transferência: ");
                    double valor = leitor.nextDouble();
                    leitor.nextLine();

                    if (banco.transferir(origem, destino, valor)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Não foi possível transferir. Verifique se as duas contas existem, "
                                + "se são diferentes e se há saldo na conta de origem.");
                    }
                    break;
                }

                case 0: {
                    System.out.println("Programa encerrado.");
                    break;
                }

                default: {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }

        leitor.close();
    }
}
