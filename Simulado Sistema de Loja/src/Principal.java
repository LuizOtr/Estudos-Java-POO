import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== SISTEMA DA LOJA =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha após o número
            } else {
                System.out.println("Opção inválida!");
                scanner.nextLine(); // Limpar buffer
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o código do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    
                    System.out.print("Digite a quantidade inicial em estoque: ");
                    int quantidade = scanner.nextInt();
                    
                    System.out.print("Digite o estoque mínimo: ");
                    int estoqueMinimo = scanner.nextInt();
                    
                    loja.cadastrarProduto(codigo, nome, preco, quantidade, estoqueMinimo);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                    
                case 2:
                    System.out.println("\nLista de Produtos:");
                    loja.listarProdutos();
                    break;
                    
                case 3:
                    System.out.print("Digite o código do produto: ");
                    int codigoVenda = scanner.nextInt();
                    
                    System.out.print("Digite a quantidade a ser vendida: ");
                    int quantidadeVenda = scanner.nextInt();
                    
                    boolean vendaSucesso = loja.realizarVenda(codigoVenda, quantidadeVenda);
                    if (vendaSucesso) {
                        System.out.println("Venda realizada com sucesso!");
                    } else {
                        System.out.println("Falha ao realizar a venda. Produto não encontrado ou estoque insuficiente.");
                    }
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
