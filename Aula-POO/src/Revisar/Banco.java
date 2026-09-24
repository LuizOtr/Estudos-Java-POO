package Revisar;

import java.util.ArrayList;

/*
 * ╔════════════════════════════════════════════════════════════════════╗
 * ║              REVISÃO PARA exercicios - CLASSE BANCO                   ║
 * ╠════════════════════════════════════════════════════════════════════╣
 * ║  TEMA DA exercicios: Listas (ArrayList) + Agregação + Integração      ║
 * ╚════════════════════════════════════════════════════════════════════╝
 *
 * ====================================================================
 * BLOCO DE ESTUDO - ARRAYLIST E PERSISTÊNCIA DE OBJETOS:
 * ====================================================================
 *
 * O QUE É O ARRAYLIST?
 *   É uma lista dinâmica do Java que armazena objetos.
 *   Pertence ao pacote java.util e precisa ser importado:
 *     import java.util.ArrayList;
 *
 * POR QUE USAR ARRAYLIST?
 *   Resolve o problema de precisar guardar VÁRIOS objetos criados
 *   dinamicamente durante a execução do programa.
 *
 *   Sem ArrayList: teríamos que criar variáveis individuais:
 *     Cliente c1, c2, c3, c4... // Impossível saber quantos!
 *
 *   Com ArrayList: guardamos todos em uma lista:
 *     ArrayList<Cliente> lista = new ArrayList<>();
 *     lista.add(novoCliente); // Adiciona quantos precisar!
 *
 * COMO A exercicios COBRA ISSO:
 *   "Implemente a classe Banco contendo um construtor para instanciar
 *    duas listas: listaClientes = new ArrayList<Cliente>();
 *    e listaContas = new ArrayList<Conta>();"
 *
 *   ATENÇÃO: As listas DEVEM ser instanciadas no CONSTRUTOR!
 *   Se esquecer o "new ArrayList<>()", ao tentar usar a lista
 *   você receberá um NullPointerException.
 *
 * ITERANDO SOBRE A LISTA (como percorrer):
 *   O for-each é o formato cobrado na exercicios:
 *     for (Cliente c : listaClientes) {
 *         c.mostrarDados();
 *     }
 *
 * ====================================================================
 * BLOCO DE ESTUDO - CLASSE GERENCIADORA:
 * ====================================================================
 *
 * A classe Banco é a GERENCIADORA do sistema. Ela:
 *   1. CRIA objetos (new Cliente, new Conta)
 *   2. ARMAZENA em listas (listaClientes.add, listaContas.add)
 *   3. BUSCA objetos nas listas (buscarCliente, buscarConta)
 *   4. REALIZA operações (depositar, sacar, transferir)
 *
 * REGRA IMPORTANTE:
 *   A classe Principal NÃO deve manipular listas!
 *   Ela apenas lê dados do teclado e chama métodos do Banco.
 *
 * MÉTODOS PRIVADOS DE BUSCA:
 *   buscarCliente(int id) e buscarConta(int numero) são PRIVATE
 *   porque são utilitários internos. Somente o Banco precisa
 *   buscar seus próprios objetos.
 *
 * ====================================================================
 * BLOCO DE ESTUDO - COMO TUDO SE CONECTA (INTEGRAÇÃO):
 * ====================================================================
 *
 * FLUXO COMPLETO NA exercicios:
 *
 *  1. Principal lê dados do teclado (Scanner)
 *  2. Principal chama banco.cadastrarCliente("João", "123")
 *  3. Banco CRIA o Cliente: new Cliente(id, nome, cpf)
 *  4. Banco ARMAZENA na lista: listaClientes.add(novoCliente)
 *  5. Principal chama banco.criarConta(idCliente)
 *  6. Banco BUSCA o Cliente: buscarCliente(idCliente)
 *  7. Banco CRIA a Conta passando o Cliente: new Conta(num, cliente)
 *     --> Aqui acontece a AGREGAÇÃO: a Conta recebe o Cliente
 *  8. Banco ARMAZENA na lista: listaContas.add(novaConta)
 *
 *  Resultado: O Banco possui listas com Clientes e Contas,
 *  onde cada Conta aponta para seu respectivo Cliente.
 *
 * ====================================================================
 */
public class Banco {

    private String nome;
    private ArrayList<Cliente> listaClientes; // Lista de objetos Cliente
    private ArrayList<Conta> listaContas; // Lista de objetos Conta
    private int proximoIdCliente;
    private int proximoNumeroConta;

    /*
     * CONSTRUTOR:
     * OBRIGATÓRIO instanciar as listas aqui!
     *
     * Dica: Se a exercicios pedir "instanciar no construtor", faça:
     * listaClientes = new ArrayList<Cliente>();
     * listaContas = new ArrayList<Conta>();
     */
    public Banco(String nome) {
        this.nome = nome;
        this.listaClientes = new ArrayList<Cliente>();
        this.listaContas = new ArrayList<Conta>();
        this.proximoIdCliente = 1;
        this.proximoNumeroConta = 1;
    }

    // ==========================================
    // MÉTODOS PRIVADOS DE BUSCA
    // ==========================================

    /*
     * buscarCliente(int id):
     * Percorre a lista de clientes com for-each.
     * Retorna o objeto encontrado ou NULL se não achar.
     *
     * Dica: Na exercicios, o método de busca é SEMPRE private,
     * pois é usado internamente pelo Banco.
     */
    private Cliente buscarCliente(int id) {
        for (Cliente c : listaClientes) {
            if (c.getId() == id) {
                return c; // Encontrou! Retorna o objeto.
            }
        }
        return null; // Não encontrou.
    }

    /*
     * buscarConta(int numero):
     * Mesmo padrão de busca, mas para contas.
     */
    private Conta buscarConta(int numero) {
        for (Conta c : listaContas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    // ==========================================
    // MÉTODOS PÚBLICOS (chamados pela Principal)
    // ==========================================

    /*
     * cadastrarCliente():
     * 1. Cria o objeto Cliente
     * 2. Adiciona na lista (PERSISTÊNCIA)
     * 3. Incrementa o contador de IDs
     * 4. Retorna o ID gerado
     */
    public int cadastrarCliente(String nome, String cpf) {
        Cliente novoCliente = new Cliente(this.proximoIdCliente, nome, cpf);
        this.listaClientes.add(novoCliente);
        this.proximoIdCliente++;
        return novoCliente.getId();
    }

    /*
     * criarConta():
     * 1. Busca o Cliente pelo ID
     * 2. Se encontrou, cria a Conta PASSANDO o Cliente (AGREGAÇÃO!)
     * 3. Adiciona na lista
     * 4. Retorna o número da conta, ou -1 se o cliente não existe
     *
     * Dica: Observe a AGREGAÇÃO acontecendo na linha:
     * new Conta(numeroConta, dono)
     * O Cliente "dono" é passado para dentro da Conta.
     */
    public int criarConta(int idCliente) {
        Cliente dono = buscarCliente(idCliente);
        if (dono == null) {
            return -1; // Cliente não encontrado
        }
        Conta novaConta = new Conta(this.proximoNumeroConta, dono);
        this.listaContas.add(novaConta);
        this.proximoNumeroConta++;
        return novaConta.getNumero();
    }

    /*
     * listarClientes():
     * Percorre a lista com for-each e exibe os dados de cada cliente.
     *
     * Dica: O formato "for (Tipo var : lista)" é o cobrado na exercicios!
     */
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

    /*
     * listarContas():
     * Exibe os dados de cada conta, incluindo o nome do titular.
     * O nome do titular é acessado via AGREGAÇÃO:
     * c.getNomeTitular() -> internamente faz: this.cliente.getNome()
     */
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

    // ==========================================
    // OPERAÇÕES BANCÁRIAS
    // ==========================================

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
