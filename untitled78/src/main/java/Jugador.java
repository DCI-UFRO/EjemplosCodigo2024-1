import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntos;
    private int juegosGanados;
    private ArrayList<Carta> mano;
    private int partidasGanadas;
    private boolean perderPartida;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.juegosGanados = 0;
        this.mano = new ArrayList<>();
        this.partidasGanadas=0;
        perderPartida = false;
    }

    public void perderPartida(){
        this.perderPartida=true;
    }

    public void recivirCarta(Carta c){
        mano.add(c);
    }

    public void calcularPuntos(){
        int puntos = 0;
        for (Carta c: mano) {
            puntos+=c.getValor();
        }
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", puntos=" + puntos +
                ", juegosGanados=" + juegosGanados +
                ", mano=" + mano +
                '}';
    }

    public void ganaPartida() {
        partidasGanadas++;
    }

    public void terminarPartida() {
        puntos=0;
        mano.clear();
    }

    public boolean isPerderPartida() {
        return perderPartida;
    }

    public String getNombre() {
        return nombre;
    }
}
