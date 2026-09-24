package aula09;

// Agregação: Conta TEM um Cliente (recebido no construtor)
// O Cliente existe independente da Conta
public class Conta {

    private int numero;
    private double saldo;
    private Cliente dono; // agregação: atributo do tipo de outra classe

    public Conta(int numero, Cliente dono) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomeDono() {
        return dono.getNome();
    }

    public Cliente getDono() {
        return dono;
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
        System.out.println("Conta nº: " + numero);
        System.out.println("Titular: " + dono.getNome());
        System.out.printf("Saldo: R$ %.2f%n", saldo);
        System.out.println("====================");
    }
}
