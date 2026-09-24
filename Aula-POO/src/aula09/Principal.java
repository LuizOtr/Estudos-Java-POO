package aula09;

import java.util.Scanner;

// A Principal so le dados e chama metodos do Banco
public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("Banco do Bairro");
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== " + banco.getNome().toUpperCase() + " =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Criar conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Extrato");
            System.out.println("6 - Listar clientes");
            System.out.println("7 - Listar contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    int id = banco.cadastrarCliente(nome, cpf);
                    System.out.println("Cliente cadastrado! ID: " + id);
                    break;

                case 2:
                    System.out.print("ID do cliente: ");
                    int idCliente = scanner.nextInt();
                    int numConta = banco.criarConta(idCliente);
                    if (numConta == -1) {
                        System.out.println("Cliente não encontrado!");
                    } else {
                        System.out.println("Conta criada! Número: " + numConta);
                    }
                    break;

                case 3:
                    System.out.print("Número da conta: ");
                    int contaDep = scanner.nextInt();
                    System.out.print("Valor do depósito: ");
                    double valDep = scanner.nextDouble();
                    if (banco.depositar(contaDep, valDep)) {
                        System.out.println("Depósito realizado!");
                    } else {
                        System.out.println("Falha no depósito.");
                    }
                    break;

                case 4:
                    System.out.print("Número da conta: ");
                    int contaSaq = scanner.nextInt();
                    System.out.print("Valor do saque: ");
                    double valSaq = scanner.nextDouble();
                    if (banco.sacar(contaSaq, valSaq)) {
                        System.out.println("Saque realizado!");
                    } else {
                        System.out.println("Falha no saque.");
                    }
                    break;

                case 5:
                    System.out.print("Número da conta: ");
                    int contaExt = scanner.nextInt();
                    if (!banco.exibirExtrato(contaExt)) {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 6:
                    banco.listarClientes();
                    break;

                case 7:
                    banco.listarContas();
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }
}
