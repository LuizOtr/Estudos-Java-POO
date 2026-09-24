package aula03;

// Testando a classe Livro criando objetos com new
public class Principal {

    public static void main(String[] args) {

        // Criando objetos da classe Livro - cada um é independente
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 1899, 256, "Garnier");
        Livro livro2 = new Livro("O Alquimista", "Paulo Coelho", 1988, 197, "Rocco");

        livro1.exibirInformacoes();
        livro2.exibirInformacoes();

        System.out.println("\n--- Operações de Empréstimo ---");
        livro1.emprestar();
        livro1.emprestar(); // Já está emprestado
        livro1.exibirInformacoes();

        System.out.println("\n--- Operações de Devolução ---");
        livro1.devolver();
        livro1.exibirInformacoes();
    }
}
