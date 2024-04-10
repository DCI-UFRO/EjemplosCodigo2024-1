public class Carta {
    private int valor;
    private String pinta;
    private String simbolo;

    public Carta(int valor, String pinta, String simbolo) {
        this.valor = valor;
        this.pinta = pinta;
        this.simbolo = simbolo;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Cartas{" +
                "valor=" + valor +
                ", pinta='" + pinta + '\'' +
                ", simbolo=" + simbolo +
                '}';
    }
}
