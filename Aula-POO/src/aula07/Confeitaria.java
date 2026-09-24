package aula07;

import java.util.ArrayList;
import java.util.Scanner;

// ArrayList: lista dinamica que cresce conforme adicionamos elementos
// Usar quando nao sabemos quantos elementos teremos. Precisa importar java.util.ArrayList
// Para tipos primitivos usar wrapper: ArrayList<Integer>, ArrayList<Double>
public class Confeitaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> nomesProdutos = new ArrayList<String>();
        ArrayList<Double> precosProdutos = new ArrayList<Double>();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== CONFEITARIA DOCE SABOR =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto por nome");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Opção inválida!");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Preço do produto: R$ ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    // add() adiciona elemento ao final da lista
                    nomesProdutos.add(nome);
                    precosProdutos.add(preco);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Produtos ---");

                    if (nomesProdutos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        // for com indice: usar quando precisa da posição do elemento
                        for (int i = 0; i < nomesProdutos.size(); i++) {
                            System.out.printf("%d. %s - R$ %.2f%n",
                                    (i + 1),
                                    nomesProdutos.get(i),
                                    precosProdutos.get(i));
                        }
                    }
                    System.out.println("-------------------------");
                    break;

                case 3:
                    System.out.print("Digite o nome para buscar: ");
                    String busca = scanner.nextLine();
                    boolean encontrou = false;

                    // for-each: usar quando nao precisa do indice
                    for (String str : nomesProdutos) {
                        if (str.equalsIgnoreCase(busca)) {
                            int indice = nomesProdutos.indexOf(str);
                            System.out.printf("Encontrado: %s - R$ %.2f%n",
                                    str, precosProdutos.get(indice));
                            encontrou = true;
                            break;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Obrigado pela visita! Volte sempre!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }
}
