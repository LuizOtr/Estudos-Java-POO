package aula04;

// Testando a classe Produto
public class Principal {

    public static void main(String[] args) {

        Produto produto1 = new Produto("Notebook Dell");
        Produto produto2 = new Produto("Mouse Gamer");

        System.out.println("=== Produtos recém-criados ===");
        produto1.exibirInformacoes();
        produto2.exibirInformacoes();

        System.out.println("\n=== Aumentando preços ===");
        produto1.aumentarPreco(4500.00);
        produto2.aumentarPreco(250.00);
        produto1.exibirInformacoes();
        produto2.exibirInformacoes();

        System.out.println("\n=== Aplicando descontos ===");
        produto1.aplicarDesconto(10);
        produto2.aplicarDesconto(15);
        produto1.exibirInformacoes();
        produto2.exibirInformacoes();
    }
}
