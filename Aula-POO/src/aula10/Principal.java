package aula10;

import java.util.Scanner;

// Menu completo com transferência
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
            System.out.println("5 - Transferir");
            System.out.println("6 - Extrato");
            System.out.println("7 - Listar clientes");
            System.out.println("8 - Listar contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    int id = banco.cadastrarCliente(nome, cpf);
                    System.out.println("Cliente cadastrado! ID: " + id);
                    break;

                case 2:
                    System.out.print("ID do cliente: ");
                    int idCli = scanner.nextInt();
                    int numConta = banco.criarConta(idCli);
                    if (numConta == -1) {
                        System.out.println("Cliente não encontrado!");
                    } else {
                        System.out.println("Conta criada! Número: " + numConta);
                    }
                    break;

                case 3:
                    System.out.print("Número da conta: ");
                    int contaDep = scanner.nextInt();
                    System.out.print("Valor: ");
                    double valDep = scanner.nextDouble();
                    System.out.println(banco.depositar(contaDep, valDep) ?
                            "Depósito realizado!" : "Falha no depósito.");
                    break;

                case 4:
                    System.out.print("Número da conta: ");
                    int contaSaq = scanner.nextInt();
                    System.out.print("Valor: ");
                    double valSaq = scanner.nextDouble();
                    System.out.println(banco.sacar(contaSaq, valSaq) ?
                            "Saque realizado!" : "Falha no saque.");
                    break;

                case 5:
                    System.out.print("Conta de origem: ");
                    int origem = scanner.nextInt();
                    System.out.print("Conta de destino: ");
                    int destino = scanner.nextInt();
                    System.out.print("Valor: ");
                    double valTransf = scanner.nextDouble();
                    System.out.println(banco.transferir(origem, destino, valTransf) ?
                            "Transferência realizada!" : "Falha na transferência.");
                    break;

                case 6:
                    System.out.print("Número da conta: ");
                    int contaExt = scanner.nextInt();
                    if (!banco.exibirExtrato(contaExt)) {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 7:
                    banco.listarClientes();
                    break;

                case 8:
                    banco.listarContas();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }
}
