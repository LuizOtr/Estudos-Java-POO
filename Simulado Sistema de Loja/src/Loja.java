import java.util.ArrayList;

public class Loja {
    private ArrayList<Produto> listaProdutos;

    public Loja() {
        this.listaProdutos = new ArrayList<>();
    }

    public void cadastrarProduto(int codigo, String nome, double preco, int quantidade, int estoqueMinimo) {
        Produto novoProduto = new Produto(codigo, nome, preco, quantidade, estoqueMinimo);
        listaProdutos.add(novoProduto);
    }

    public void listarProdutos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado na loja.");
            return;
        }
        for (Produto p : listaProdutos) {
            System.out.println("-----------------------------");
            p.exibirDados();
        }
        System.out.println("-----------------------------");
    }

    private Produto buscarProduto(int codigo) {
        for (Produto p : listaProdutos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null; // Retorna null se não encontrar
    }

    public boolean realizarVenda(int codigo, int quantidade) {
        Produto produto = buscarProduto(codigo);
        if (produto != null) {
            return produto.getEstoque().retirar(quantidade);
        }
        return false;
    }
}
