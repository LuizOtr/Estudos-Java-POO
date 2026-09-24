public class Estoque {
    private int quantidade;
    private int estoqueMinimo;

    public Estoque(int quantidade, int estoqueMinimo) {
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public boolean retirar(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
            return true;
        }
        return false;
    }

    public void exibirDados() {
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Estoque mínimo: " + estoqueMinimo);
    }
}
