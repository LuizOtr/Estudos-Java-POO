package aula05;

// Encapsulamento: atributos private, acesso via get/set
// private impede acesso direto de fora da classe, protegendo os dados
public class Conta {

    private String nome;
    private int numero;
    private double saldo;

    public Conta(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
        this.saldo = 0.0;
    }

    // GET: recupera o valor do atributo
    public String getNome() {
        return this.nome;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // SET: atribui novo valor ao atributo
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Saldo não tem set publico, só muda via depositar/sacar (proteção)
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso!%n", valor);
            return true;
        }
        System.out.println("Valor inválido para depósito.");
        return false;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valor);
            return true;
        }
        System.out.println("Saldo insuficiente ou valor inválido.");
        return false;
    }

    public void extrato() {
        System.out.println("====================");
        System.out.println("  EXTRATO DA CONTA");
        System.out.println("====================");
        System.out.println("Titular: " + this.nome);
        System.out.println("Conta nº: " + this.numero);
        System.out.printf("Saldo: R$ %.2f%n", this.saldo);
        System.out.println("====================");
    }
}
