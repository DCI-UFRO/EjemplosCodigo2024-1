import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> mano;
    private int partidasGanadas;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
        this.partidasGanadas = 0;
        this.puntos = 0;
    }


    public void addCarta(Carta carta) {
        this.mano.add(carta);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", mano=" + mano +
                ", partidasGanadas=" + partidasGanadas +
                ", puntos=" + puntos +
                '}';
    }

    public int calcularPuntos() {
        int puntos =0;
        for (Carta c :mano) {
            puntos+=c.getValor();
        }
        return puntos;
    }

    public void ganarPartida() {
        this.partidasGanadas++;
    }
}
