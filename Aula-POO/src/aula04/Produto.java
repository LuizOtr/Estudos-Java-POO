package aula04;

// Classe Produto com preço inicializado em zero no construtor
public class Produto {

    String nome;
    double preco;

    // Construtor recebe só o nome, preço começa zerado
    public Produto(String nome) {
        this.nome = nome;
        this.preco = 0.0;
    }

    // Soma valor ao preço atual
    public void aumentarPreco(double valor) {
        if (valor > 0) {
            this.preco += valor;
            System.out.printf("Preço do produto \"%s\" aumentado em R$ %.2f%n", nome, valor);
        } else {
            System.out.println("Valor inválido para aumento.");
        }
    }

    // Calcula desconto em percentual: preco * percentual / 100
    public void aplicarDesconto(double percentual) {
        if (percentual > 0 && percentual <= 100) {
            double desconto = this.preco * percentual / 100;
            this.preco -= desconto;
            System.out.printf("Desconto de %.1f%% aplicado em \"%s\". Economia de R$ %.2f%n",
                    percentual, nome, desconto);
        } else {
            System.out.println("Percentual de desconto inválido.");
        }
    }

    public void exibirInformacoes() {
        System.out.println("-----------------------------");
        System.out.println("Produto: " + nome);
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("-----------------------------");
    }
}
