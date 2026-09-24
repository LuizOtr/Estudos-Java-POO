package Revisao;

import java.util.ArrayList;

// Classe gerenciadora: cria, armazena e busca objetos nas listas
// As listas devem ser instanciadas no construtor com new ArrayList<>()
// Metodos de busca sao private (uso interno), o resto é public
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

    // Busca interna: percorre a lista e retorna null se nao achar
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

    // Cria o Cliente e guarda na lista
    public int cadastrarCliente(String nome, String cpf) {
        Cliente novoCliente = new Cliente(this.proximoIdCliente, nome, cpf);
        this.listaClientes.add(novoCliente);
        this.proximoIdCliente++;
        return novoCliente.getId();
    }

    // Busca o Cliente e passa ele para a nova Conta (agregação acontece aqui)
    public int criarConta(int idCliente) {
        Cliente dono = buscarCliente(idCliente);
        if (dono == null) {
            return -1;
        }
        Conta novaConta = new Conta(this.proximoNumeroConta, dono);
        this.listaContas.add(novaConta);
        this.proximoNumeroConta++;
        return novaConta.getNumero();
    }

    // Percorre a lista com for-each
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
            System.out.println("Conta nº: " + c.getNumero());
            System.out.println("Titular: " + c.getNomeTitular());
            System.out.printf("Saldo: R$ %.2f%n", c.getSaldo());
        }
        System.out.println("-----------------------------");
    }

    public boolean depositar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta == null)
            return false;
        return conta.depositar(valor);
    }

    public boolean sacar(int numeroConta, double valor) {
        Conta conta = buscarConta(numeroConta);
        if (conta == null)
            return false;
        return conta.sacar(valor);
    }

    public boolean transferir(int numOrigem, int numDestino, double valor) {
        Conta origem = buscarConta(numOrigem);
        Conta destino = buscarConta(numDestino);

        if (origem == null || destino == null)
            return false;
        if (origem.getNumero() == destino.getNumero())
            return false;
        if (!origem.sacar(valor))
            return false;

        destino.depositar(valor);
        return true;
    }

    public boolean exibirExtrato(int numeroConta) {
        Conta conta = buscarConta(numeroConta);
        if (conta == null)
            return false;
        System.out.println("BANCO: " + this.nome);
        conta.extrato();
        return true;
    }

    public String getNome() {
        return this.nome;
    }
}
