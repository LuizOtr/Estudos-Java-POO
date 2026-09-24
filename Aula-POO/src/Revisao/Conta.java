package Revisao;

// Agregação: Conta TEM um Cliente (private Cliente cliente)
// O Cliente é criado fora e passado no construtor da Conta
// Dentro da Conta, acessamos dados do cliente com this.cliente.getNome()
// Saldo não tem set publico, so muda via depositar() e sacar()
public class Conta {

    private int numero;
    private double saldo;
    private Cliente cliente; // agregação

    // Recebe o Cliente ja criado externamente
    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // Retorna o objeto Cliente inteiro
    public Cliente getCliente() {
        return this.cliente;
    }

    // Acessa o nome do titular via agregação
    public String getNomeTitular() {
        return this.cliente.getNome();
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void extrato() {
        System.out.println("====================");
        System.out.println("  EXTRATO DA CONTA");
        System.out.println("====================");
        System.out.println("Conta nº: " + this.numero);
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("CPF: " + this.cliente.getCpf());
        System.out.printf("Saldo: R$ %.2f%n", this.saldo);
        System.out.println("====================");
    }
}
