package Revisar;

/*
 * ╔════════════════════════════════════════════════════════════════════╗
 * ║              REVISÃO PARA exercicios - CLASSE CLIENTE                 ║
 * ╠════════════════════════════════════════════════════════════════════╣
 * ║  TEMA DA exercicios: Classes/Objetos + Encapsulamento                 ║
 * ╚════════════════════════════════════════════════════════════════════╝
 *
 * ====================================================================
 * BLOCO DE ESTUDO - CLASSES E OBJETOS:
 * ====================================================================
 *
 * O que é uma CLASSE?
 *   É a definição (molde/planta) de uma entidade. Define QUAIS
 *   atributos e métodos os objetos terão.
 *   Exemplo: A classe Cliente define que todo cliente terá id, nome e cpf.
 *
 * O que é um OBJETO?
 *   É uma INSTÂNCIA da classe. É a "cópia concreta" criada na memória.
 *   Exemplo: Cliente c1 = new Cliente(1, "João", "123.456.789-00");
 *   Aqui, c1 é um OBJETO da classe Cliente.
 *
 * ====================================================================
 * BLOCO DE ESTUDO - ENCAPSULAMENTO:
 * ====================================================================
 *
 * Por que todos os atributos são PRIVATE?
 *   O modificador "private" impede que outras classes acessem ou
 *   modifiquem os atributos diretamente. Isso PROTEGE os dados.
 *
 * Como acessar atributos private de fora?
 *   Através de métodos públicos GET (para LER) e SET (para ESCREVER).
 *
 * COMO A exercicios PODE COBRAR:
 *   "Crie a classe Cliente com atributos privados e métodos de acesso."
 *   Isso significa:
 *     - private int id;
 *     - public int getId() { return this.id; }
 *     - public void setId(int id) { this.id = id; }
 *
 * ====================================================================
 * BLOCO DE ESTUDO - COMO CLIENTE SE CONECTA COM CONTA (AGREGAÇÃO):
 * ====================================================================
 *
 * A classe Conta possui um atributo do tipo Cliente:
 *     private Cliente cliente;
 *
 * Isso significa que UMA CONTA PERTENCE A UM CLIENTE.
 * Na exercicios, isso pode ser chamado de:
 *   - Associação: relação genérica entre classes.
 *   - Agregação: uma classe "usa" outra (mas a outra pode existir sozinha).
 *
 * O fluxo na exercicios será:
 *   1. Criar o Cliente: Cliente c = new Cliente(1, "João", "123");
 *   2. Passar o Cliente para a Conta: Conta conta = new Conta(1, c);
 *   3. Dentro da Conta, acessar dados do cliente: cliente.getNome();
 *
 * ====================================================================
 */
public class Cliente {

    // Atributos PRIVADOS (encapsulamento obrigatório)
    private int id;
    private String nome;
    private String cpf;

    /*
     * CONSTRUTOR:
     * Inicializa todos os atributos do cliente.
     * É chamado automaticamente quando usamos: new Cliente(...)
     */
    public Cliente(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    // ==========================================
    // MÉTODOS GET (Getters) - Para LER valores
    // ==========================================

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    // =============================================
    // MÉTODOS SET (Setters) - Para ALTERAR valores
    // =============================================

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /*
     * Método para exibir os dados do cliente.
     * Muito útil para debug e para listar clientes.
     */
    public void mostrarDados() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
    }
}
