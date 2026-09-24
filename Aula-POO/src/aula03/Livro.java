package aula03;

// Classe = molde de uma entidade real. Atributos = características, Métodos = ações.
// Nomes de classe começam com maiúscula, variáveis com minúscula.
public class Livro {

    String titulo;
    String autor;
    int ano;
    int numPaginas;
    String editora;
    boolean emprestado;

    // Construtor: mesmo nome da classe, sem tipo de retorno. Inicializa o objeto.
    public Livro(String titulo, String autor, int ano, int numPaginas, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.numPaginas = numPaginas;
        this.editora = editora;
        this.emprestado = false;
    }

    public boolean emprestar() {
        if (!emprestado) {
            emprestado = true;
            System.out.println("Livro \"" + titulo + "\" emprestado com sucesso!");
            return true;
        } else {
            System.out.println("Livro \"" + titulo + "\" já está emprestado.");
            return false;
        }
    }

    public boolean devolver() {
        if (emprestado) {
            emprestado = false;
            System.out.println("Livro \"" + titulo + "\" devolvido com sucesso!");
            return true;
        } else {
            System.out.println("Livro \"" + titulo + "\" já está na biblioteca.");
            return false;
        }
    }

    public void exibirInformacoes() {
        System.out.println("========== DADOS DO LIVRO ==========");
        System.out.println("Título:    " + titulo);
        System.out.println("Autor:     " + autor);
        System.out.println("Ano:       " + ano);
        System.out.println("Páginas:   " + numPaginas);
        System.out.println("Editora:   " + editora);
        System.out.println("Status:    " + (emprestado ? "Emprestado" : "Disponível"));
        System.out.println("====================================");
    }
}
