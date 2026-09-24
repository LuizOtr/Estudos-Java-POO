public class Transacao {

    private String tipo;
    private double valor;

    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return this.tipo;
    }

    public double getValor() {
        return this.valor;
    }
}
