import java.util.ArrayList;
import java.util.Scanner;

// ****Principal: arreglo de jugadores
// ****Principal: repartir cartas iniciales * revolver
// ****Jugador: jugadores determinan puntos

// ****Principal :jugar partida:
// ****- determinar ganador
// ****- iterar juego (repartir carta o no)
// ****- calcular nuevamente puntos
// ****- si nadie saca cartas se termina la partida

// Principal: determinar fin de juego
//  - determinar ganador


public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Carta> mazo = crearMazo();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        int nJugadores = insertJugadores();
        for (int i = 0; i < nJugadores; i++) {
            System.out.println("inserta el nombre del jugador");
            String nombre = teclado.next();
            jugadores.add(new Jugador(nombre));
        }

        // partida
        boolean finalizarPartida = false;
        for (Jugador j: jugadores) {
            repartirCartasInicioPartida(mazo,j);
        }
        finalizarPartida = determinarGanador(jugadores);
        while(!finalizarPartida){
            int repartirCarta=0;
            for (Jugador j: jugadores) {
                if(repartirCarta(mazo,j)){
                    repartirCarta++;
                };
            }
            finalizarPartida = determinarGanador(jugadores);
            if(repartirCarta==0&&!finalizarPartida){
                finalizarPartida=determinarGanador(jugadores,repartirCarta);
            }
        }
        for (Jugador j: jugadores){
            j.terminarPartida();
        }
        mostrarJugadores(jugadores);

    }

    private static boolean determinarGanador(ArrayList<Jugador> jugadores, int repartirCarta) {
        for (Jugador j:jugadores) {
            if(j.getPuntos()>20){
                j.perderPartida();
            }
        }
        int mayor=0;
        int mayorIndex = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if(jugadores.get(i).getPuntos()>mayor &&
                    !jugadores.get(i).isPerderPartida() ){
                mayor=jugadores.get(i).getPuntos();
                mayorIndex = i;
            }
        }
        jugadores.get(mayorIndex).ganaPartida();
        return true;
    }

    private static boolean repartirCarta(ArrayList<Carta> mazo, Jugador j) {
        if(mazo.size()==0){
            crearMazo();
        }
        boolean nuevaCarta =false;
        Scanner teclado = new Scanner(System.in);
        System.out.println(j.getNombre()+" desea sacar una carta?si/no");
        String respuesta = teclado.next();
        if(respuesta.equals("si")){
            int indiceCarta = (int)(Math.random()* mazo.size());
            Carta c = mazo.get(indiceCarta);
            mazo.remove(indiceCarta);
            j.recivirCarta(c);
            nuevaCarta=true;
        }else{
            System.out.println("no se repartira una carta");
        }
        j.calcularPuntos();

        return nuevaCarta;
    }

    private static boolean determinarGanador(ArrayList<Jugador> jugadores) {
        boolean hayGanadores = false;
        for (Jugador j: jugadores) {
            if(j.getPuntos()==20){
                j.ganaPartida();
                hayGanadores=true;
            }
        }
        return hayGanadores;

    }

    private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        for (Jugador j: jugadores) {
            System.out.println(j);
        }
    }

    private static void repartirCartasInicioPartida(ArrayList<Carta> mazo, Jugador j) {

        for (int i = 0; i < 3; i++) {
            if(mazo.size()<=3){
                crearMazo();
            }
            int indiceCarta = (int)(Math.random()* mazo.size());
            Carta c = mazo.get(indiceCarta);
            mazo.remove(indiceCarta);
            j.recivirCarta(c);
        }
        j.calcularPuntos();

    }

    private static int insertJugadores() {
        return 2;
    }

    private static void mostrar(ArrayList<Carta> mazo) {
        for (Carta c:mazo) {
            System.out.println(c);
        }
    }

    private static ArrayList<Carta> crearMazo() {
        String[] pintas = {"Pica", "Trebol","Diamante", "Corazón"};
        String[] simbolo = {"a","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int[] valor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        ArrayList<Carta> cartas = new ArrayList<>();

        for (int i = 0; i < pintas.length; i++) {
            for (int j = 0; j < simbolo.length; j++) {
                cartas.add(new Carta(valor[j],pintas[i],simbolo[j]));
            }
        }
        return cartas;
    }
}
