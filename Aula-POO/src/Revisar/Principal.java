package Revisar;

import java.util.Scanner;

/*
 * ╔════════════════════════════════════════════════════════════════════╗
 * ║         REVISÃO PARA exercicios - CLASSE PRINCIPAL                    ║
 * ╠════════════════════════════════════════════════════════════════════╣
 * ║  Integra todos os 4 temas da exercicios em um sistema funcional       ║
 * ╚════════════════════════════════════════════════════════════════════╝
 *
 * ====================================================================
 * BLOCO DE ESTUDO - O PAPEL DA CLASSE PRINCIPAL:
 * ====================================================================
 *
 * A classe Principal é APENAS a interface com o usuário.
 * Ela faz 3 coisas:
 *   1. Lê dados do teclado (Scanner)
 *   2. Chama métodos da classe gerenciadora (Banco)
 *   3. Exibe mensagens de sucesso/erro ao usuário
 *
 * A Principal NÃO deve:
 *   ❌ Criar objetos Cliente ou Conta diretamente
 *   ❌ Manipular listas (adicionar, remover, buscar)
 *   ❌ Fazer cálculos bancários (somar saldo, etc.)
 *
 * Tudo isso é responsabilidade do BANCO!
 *
 * ====================================================================
 * RESUMO DOS 4 TEMAS DA exercicios CONECTADOS:
 * ====================================================================
 *
 * 1. CLASSES E OBJETOS:
 *    - Cliente, Conta, Banco e Principal são todas CLASSES.
 *    - "new Banco(...)" cria um OBJETO da classe Banco.
 *
 * 2. ENCAPSULAMENTO:
 *    - Todos os atributos são PRIVATE.
 *    - Acesso apenas via GET/SET públicos.
 *    - O saldo não tem setter (protegido por depositar/sacar).
 *
 * 3. LISTAS (ArrayList):
 *    - O Banco armazena clientes e contas em ArrayLists.
 *    - Os métodos de busca percorrem as listas com for-each.
 *    - As listas são instanciadas no construtor do Banco.
 *
 * 4. AGREGAÇÃO:
 *    - A Conta possui um atributo "private Cliente cliente".
 *    - O Cliente é passado via construtor da Conta.
 *    - Dentro da Conta, acessamos dados do cliente:
 *      this.cliente.getNome()
 *
 * ====================================================================
 */
public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando o objeto Banco (classe gerenciadora)
        Banco banco = new Banco("Banco POO");
        int opcao = -1;

        // Menu iterativo - roda até o usuário digitar 0
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
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1: // CADASTRAR CLIENTE
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    // A Principal chama o Banco, que cria o Cliente internamente
                    int idGerado = banco.cadastrarCliente(nome, cpf);
                    System.out.println("Cliente cadastrado com sucesso! ID: " + idGerado);
                    break;

                case 2: // CRIAR CONTA (aqui acontece a AGREGAÇÃO)
                    System.out.print("Informe o ID do cliente: ");
                    int idCliente = scanner.nextInt();

                    // O Banco busca o Cliente e cria a Conta passando o Cliente
                    int numContaCriada = banco.criarConta(idCliente);
                    if (numContaCriada == -1) {
                        System.out.println("Erro: Cliente não encontrado!");
                    } else {
                        System.out.println("Conta criada com sucesso! Número: " + numContaCriada);
                    }
                    break;

                case 3: // DEPOSITAR
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

                case 4: // SACAR
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

                case 5: // TRANSFERIR
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

                case 6: // EXTRATO
                    System.out.print("Número da conta: ");
                    int contaExt = scanner.nextInt();

                    if (!banco.exibirExtrato(contaExt)) {
                        System.out.println("Erro: Conta não encontrada!");
                    }
                    break;

                case 7: // LISTAR CLIENTES
                    System.out.println("\n--- Clientes Cadastrados ---");
                    banco.listarClientes();
                    break;

                case 8: // LISTAR CONTAS
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
