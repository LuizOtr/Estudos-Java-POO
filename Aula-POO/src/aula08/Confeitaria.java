package aula08;

import java.util.ArrayList;
import java.util.Scanner;

// Reforço de ArrayList: add() adiciona, remove() remove, get() acessa, size() conta
public class Confeitaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> nomesProdutos = new ArrayList<>();
        ArrayList<Double> precosProdutos = new ArrayList<>();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== CONFEITARIA DOCE SABOR =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Remover produto");
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

                    nomesProdutos.add(nome);
                    precosProdutos.add(preco);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- Cardápio ---");

                    if (nomesProdutos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        // for-each: percorre cada elemento da lista
                        for (String str : nomesProdutos) {
                            int i = nomesProdutos.indexOf(str);
                            System.out.printf("%d. %s - R$ %.2f%n",
                                    (i + 1), str, precosProdutos.get(i));
                        }
                    }
                    System.out.println("-----------------");
                    break;

                case 3:
                    if (nomesProdutos.isEmpty()) {
                        System.out.println("Nenhum produto para remover.");
                    } else {
                        for (int i = 0; i < nomesProdutos.size(); i++) {
                            System.out.printf("%d. %s%n", (i + 1), nomesProdutos.get(i));
                        }
                        System.out.print("Digite o número do produto para remover: ");
                        int indice = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (indice >= 0 && indice < nomesProdutos.size()) {
                            // remove() remove o elemento na posição e reajusta a lista
                            String removido = nomesProdutos.remove(indice);
                            precosProdutos.remove(indice);
                            System.out.println("Produto \"" + removido + "\" removido!");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Obrigado pela visita!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }
}
