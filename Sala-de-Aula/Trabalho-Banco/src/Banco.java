import java.util.ArrayList;

public class Banco {

    private String nome;
    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;
    private int idCliente;
    private int numeroConta;

    public Banco() {
        this.nome = "Banco do Bairro";
        this.clientes = new ArrayList<Cliente>();
        this.contas = new ArrayList<Conta>();
        this.idCliente = 1;
        this.numeroConta = 1;
    }

    public Banco(String nome) {
        this();
        this.nome = nome;
    }

    private Cliente buscarCliente(int id) {
        for (Cliente c : this.clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    private Conta buscarConta(int numero) {
        for (Conta c : this.contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    public int cadastrarCliente(String nome, String cpf) {
        Cliente novo = new Cliente(this.idCliente, nome, cpf);
        this.clientes.add(novo);
        this.idCliente++;
        return novo.getId();
    }

    public void listarClientes() {
        boolean temCliente = false;

        for (Cliente c : this.clientes) {
            temCliente = true;
            System.out.println("-----------------------------");
            c.mostrarDados();
        }

        if (temCliente) {
            System.out.println("-----------------------------");
        } else {
            System.out.println("Nenhum cliente cadastrado.");
        }
    }

    public int criarConta(int idCliente) {
        Cliente dono = buscarCliente(idCliente);
        if (dono == null) {
            return -1;
        }

        Conta nova = new Conta(this.numeroConta, dono);
        this.contas.add(nova);
        this.numeroConta++;
        return nova.getNumero();
    }

    public void listarContas() {
        boolean temConta = false;

        for (Conta c : this.contas) {
            temConta = true;
            System.out.println("-----------------------------");
            System.out.println("Conta: " + c.getNumero());
            System.out.println("Titular: " + c.getNome());
            System.out.println("Saldo: R$ " + c.getSaldo());
        }

        if (temConta) {
            System.out.println("-----------------------------");
        } else {
            System.out.println("Nenhuma conta cadastrada.");
        }
    }

    public boolean depositar(int numero, double valor) {
        Conta conta = buscarConta(numero);
        if (conta == null) {
            return false;
        }
        return conta.depositar(valor);
    }

    public boolean sacar(int numero, double valor) {
        Conta conta = buscarConta(numero);
        if (conta == null) {
            return false;
        }
        return conta.sacar(valor);
    }

    public boolean exibirExtrato(int numero) {
        Conta conta = buscarConta(numero);
        if (conta == null) {
            return false;
        }

        System.out.println("====================");
        System.out.println("BANCO: " + this.nome);
        conta.extrato();
        return true;
    }

    public boolean transferir(int numeroOrigem, int numeroDestino, double valor) {
        Conta origem = buscarConta(numeroOrigem);
        Conta destino = buscarConta(numeroDestino);

        if (origem == null || destino == null) {
            return false;
        }
        if (origem.getNumero() == destino.getNumero()) {
            return false;
        }
        if (origem.sacar(valor) == false) {
            return false;
        }

        destino.depositar(valor);
        return true;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
