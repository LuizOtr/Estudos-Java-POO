package Revisar;

/*
 * ╔════════════════════════════════════════════════════════════════════╗
 * ║              REVISÃO PARA exercicios - CLASSE CONTA                   ║
 * ╠════════════════════════════════════════════════════════════════════╣
 * ║  TEMA DA exercicios: Encapsulamento + Agregação/Associação            ║
 * ╚════════════════════════════════════════════════════════════════════╝
 *
 * ====================================================================
 * BLOCO DE ESTUDO - AGREGAÇÃO (COMO CAI NA exercicios):
 * ====================================================================
 *
 * A AGREGAÇÃO é quando uma classe possui um atributo que é um OBJETO
 * de outra classe. Neste caso:
 *
 *   private Cliente cliente;   <-- A Conta TEM um Cliente
 *
 * COMO A exercicios COBRA ISSO:
 *   "A classe Conta deve agregar um cliente. Para isso, ela deve
 *    possuir o atributo private Cliente cliente; e recebê-lo via
 *    construtor: public Conta(int numero, Cliente cliente)"
 *
 * O QUE ACONTECE POR TRÁS:
 *   Quando escrevemos: Conta c = new Conta(1, clienteJoao);
 *   A variável "cliente" dentro da Conta passa a APONTAR para o
 *   mesmo objeto "clienteJoao" que foi criado fora. Isso é agregação:
 *   o Cliente existe independentemente da Conta.
 *
 * DIFERENÇA ENTRE AGREGAÇÃO E COMPOSIÇÃO:
 *   - AGREGAÇÃO: O objeto "filho" (Cliente) pode existir SEM o "pai" (Conta).
 *     Se a Conta for deletada, o Cliente continua existindo.
 *   - COMPOSIÇÃO: O objeto "filho" NÃO existe sem o "pai".
 *     Ex: Se deletarmos um Pedido, os ItensDoPedido também são deletados.
 *
 * COMO IDENTIFICAR NA exercicios:
 *   Se o enunciado diz "a Conta POSSUI um Cliente" ou "a Conta AGREGA
 *   um Cliente", você deve:
 *   1. Criar o atributo: private Cliente cliente;
 *   2. Receber no construtor: public Conta(int numero, Cliente cliente)
 *   3. Acessar dados do cliente via getter: this.cliente.getNome()
 *
 * ====================================================================
 * BLOCO DE ESTUDO - ENCAPSULAMENTO NA CONTA:
 * ====================================================================
 *
 * O saldo é private e NÃO possui setSaldo() público.
 * Isso garante que o saldo SÓ pode ser alterado através de depositar()
 * e sacar(), que possuem VALIDAÇÕES.
 *
 * Sem encapsulamento, qualquer classe poderia fazer:
 *   conta.saldo = -99999; // PERIGO!
 *
 * Com encapsulamento, isso é impossível. O saldo está protegido.
 *
 * ====================================================================
 */
public class Conta {

    // Atributos PRIVADOS
    private int numero;
    private double saldo;
    private Cliente cliente; // AGREGAÇÃO: Conta TEM um Cliente

    /*
     * CONSTRUTOR:
     * Recebe o número da conta e o objeto Cliente (já criado externamente).
     * O saldo inicia em zero.
     *
     * Dica: O Cliente é criado ANTES e PASSADO para a Conta.
     * Isso é AGREGAÇÃO - o Cliente existe independentemente.
     */
    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    // ==========================================
    // GETTERS
    // ==========================================

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    /*
     * getCliente(): Retorna o OBJETO Cliente inteiro.
     * Isso permite acessar os dados do cliente de fora:
     * conta.getCliente().getNome();
     */
    public Cliente getCliente() {
        return this.cliente;
    }

    /*
     * Método auxiliar para facilitar o acesso ao nome do titular.
     * Internamente, usa a agregação: this.cliente.getNome()
     */
    public String getNomeTitular() {
        return this.cliente.getNome();
    }

    // ==========================================
    // SETTERS
    // ==========================================

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // NÃO criamos setSaldo()! O saldo só muda via depositar/sacar.

    // ==========================================
    // OPERAÇÕES BANCÁRIAS
    // ==========================================

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

    /*
     * Exibe o extrato completo da conta.
     * Observe como acessamos o nome do cliente usando
     * this.cliente.getNome() - isso é a AGREGAÇÃO em ação.
     */
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
