package aula09;

import java.util.ArrayList;

// Classe gerenciadora: centraliza todas as operações sobre clientes e contas
// As listas devem ser instanciadas no construtor com new ArrayList<>()
// A Principal so chama metodos do Banco, nunca manipula as listas diretamente
public class Banco {

    private String nome;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Conta> listaContas;
    private int proximoIdCliente;
    private int proximoNumeroConta;

    public Banco(String nome) {
        this.nome = nome;
        this.listaClientes = new ArrayList<Cliente>();
        this.listaContas = new ArrayList<Conta>();
        this.proximoIdCliente = 1;
        this.proximoNumeroConta = 1;
    }

    // Busca interna (private): so o Banco usa, retorna null se nao achar
    private Cliente buscarCliente(int id) {
        for (Cliente c : listaClientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    private Conta buscarConta(int numero) {
        for (Conta c : listaContas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    // Cria o objeto, adiciona na lista (persistência) e retorna o ID
    public int cadastrarCliente(String nome, String cpf) {
        Cliente novo = new Cliente(proximoIdCliente, nome, cpf);
        listaClientes.add(novo);
        proximoIdCliente++;
        return novo.getId();
    }

    // Busca o cliente e cria a conta passando ele (agregação)
    public int criarConta(int idCliente) {
        Cliente dono = buscarCliente(idCliente);
        if (dono == null) {
            return -1;
        }
        Conta nova = new Conta(proximoNumeroConta, dono);
        listaContas.add(nova);
        proximoNumeroConta++;
        return nova.getNumero();
    }

    // for-each para percorrer a lista
    public void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : listaClientes) {
            System.out.println("-----------------------------");
            c.mostrarDados();
        }
        System.out.println("-----------------------------");
    }

    public void listarContas() {
        if (listaContas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }
        for (Conta c : listaContas) {
            System.out.println("-----------------------------");
            System.out.println("Conta: " + c.getNumero());
            System.out.println("Titular: " + c.getNomeDono());
            System.out.printf("Saldo: R$ %.2f%n", c.getSaldo());
        }
        System.out.println("-----------------------------");
    }

    public boolean depositar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta == null) return false;
        return conta.depositar(valor);
    }

    public boolean sacar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta == null) return false;
        return conta.sacar(valor);
    }

    public boolean exibirExtrato(int numeroConta) {
        Conta conta = buscarConta(numeroConta);
        if (conta == null) return false;
        System.out.println("BANCO: " + this.nome);
        conta.extrato();
        return true;
    }

    public String getNome() {
        return nome;
    }
}
