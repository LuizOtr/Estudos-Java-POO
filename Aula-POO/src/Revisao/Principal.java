package Revisao;

import java.util.Scanner;

// A Principal so le dados do teclado e chama metodos do Banco
// Nao cria objetos diretamente nem mexe nas listas
public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("Banco POO");
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== " + banco.getNome().toUpperCase() + " =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Criar conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Extrato");
            System.out.println("7 - Listar clientes");
            System.out.println("8 - Listar contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    int idGerado = banco.cadastrarCliente(nome, cpf);
                    System.out.println("Cliente cadastrado com sucesso! ID: " + idGerado);
                    break;

                case 2:
                    System.out.print("Informe o ID do cliente: ");
                    int idCliente = scanner.nextInt();
                    int numContaCriada = banco.criarConta(idCliente);
                    if (numContaCriada == -1) {
                        System.out.println("Erro: Cliente não encontrado!");
                    } else {
                        System.out.println("Conta criada com sucesso! Número: " + numContaCriada);
                    }
                    break;

                case 3:
                    System.out.print("Número da conta: ");
                    int contaDep = scanner.nextInt();
                    System.out.print("Valor do depósito: R$ ");
                    double valDep = scanner.nextDouble();
                    if (banco.depositar(contaDep, valDep)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Erro: Conta não encontrada ou valor inválido.");
                    }
                    break;

                case 4:
                    System.out.print("Número da conta: ");
                    int contaSaq = scanner.nextInt();
                    System.out.print("Valor do saque: R$ ");
                    double valSaq = scanner.nextDouble();
                    if (banco.sacar(contaSaq, valSaq)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Erro: Conta não encontrada, saldo insuficiente ou valor inválido.");
                    }
                    break;

                case 5:
                    System.out.print("Conta de origem: ");
                    int origem = scanner.nextInt();
                    System.out.print("Conta de destino: ");
                    int destino = scanner.nextInt();
                    System.out.print("Valor da transferência: R$ ");
                    double valTransf = scanner.nextDouble();
                    if (banco.transferir(origem, destino, valTransf)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Erro: Falha na transferência.");
                    }
                    break;

                case 6:
                    System.out.print("Número da conta: ");
                    int contaExt = scanner.nextInt();
                    if (!banco.exibirExtrato(contaExt)) {
                        System.out.println("Erro: Conta não encontrada!");
                    }
                    break;

                case 7:
                    System.out.println("\n--- Clientes Cadastrados ---");
                    banco.listarClientes();
                    break;

                case 8:
                    System.out.println("\n--- Contas Cadastradas ---");
                    banco.listarContas();
                    break;

                case 0:
                    System.out.println("Sistema encerrado. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
