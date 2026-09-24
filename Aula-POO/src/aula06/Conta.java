package aula06;

// Reforço de encapsulamento: private nos atributos, public nos métodos get/set
public class Conta {

    private String nome;
    private int numero;
    private double saldo;

    public Conta(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
        this.saldo = 0.0;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

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
