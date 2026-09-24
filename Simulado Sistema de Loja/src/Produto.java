public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private Estoque estoque;

    public Produto(int codigo, String nome, double preco, int quantidade, int estoqueMinimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = new Estoque(quantidade, estoqueMinimo);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        estoque.exibirDados();
    }
}
