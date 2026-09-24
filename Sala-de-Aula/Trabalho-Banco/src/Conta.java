import java.util.ArrayList;

public class Conta {

    private int numero;
    private String nome;
    private Cliente cliente;
    private double saldo;
    private ArrayList<Transacao> movimentacoes;

    public Conta() {
        this.numero = 0;
        this.nome = "";
        this.cliente = null;
        this.saldo = 0;
        this.movimentacoes = new ArrayList<Transacao>();
    }

    public Conta(double saldo) {
        this.numero = 0;
        this.nome = "";
        this.cliente = null;
        this.saldo = saldo;
        this.movimentacoes = new ArrayList<Transacao>();
    }

    public Conta(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        this.cliente = null;
        this.saldo = 0;
        this.movimentacoes = new ArrayList<Transacao>();
    }

    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.nome = cliente.getNome();
        this.saldo = 0;
        this.movimentacoes = new ArrayList<Transacao>();
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
            this.movimentacoes.add(new Transacao("DEPÓSITO", valor));
            return true;
        } else {
            return false;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo = this.saldo - valor;
            this.movimentacoes.add(new Transacao("SAQUE", valor));
            return true;
        } else {
            return false;
        }
    }

    public void extrato() {
        System.out.println("====================");
        System.out.println("DADOS DA CONTA");
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.nome);
        if (this.getCliente() != null) {
            System.out.println("CPF: " + this.getCliente().getCpf());
        }
        System.out.println("--------------------");
        System.out.println("MOVIMENTAÇÕES");
        System.out.println("--------------------");

        int quantidade = 0;
        for (Transacao t : this.movimentacoes) {
            quantidade++;
            System.out.println(quantidade + " - " + t.getTipo() + " - R$ " + t.getValor());
        }
        if (quantidade == 0) {
            System.out.println("Nenhuma movimentação realizada.");
        }

        System.out.println("--------------------");
        System.out.println("Total de movimentações: " + quantidade);
        System.out.println("SALDO FINAL: R$ " + this.saldo);
        System.out.println("====================");
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transacao> getMovimentacoes() {
        return this.movimentacoes;
    }
}
