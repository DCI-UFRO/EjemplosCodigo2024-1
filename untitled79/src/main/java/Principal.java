import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Jugador
        // Carta

        /*Funciones de Juego
        - (Principal)Partida
            - (Principal)generar a jugadores
            - (Jugador)determinar puntos
            - (Principal)determinar condiciones de victoria
            - (Principal)repartir cartas
        - (Principal)nueva partidas
        - (Principal)determinar ganador
        */
        ArrayList<Carta> mazo = new ArrayList<>();
        generadorCartas(mazo);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        determinarJugadores(jugadores);

        do {
            partida(jugadores, mazo);

        }while(/*fin de juego*/);
        
    }

    private static void partida(ArrayList<Jugador> jugadores, ArrayList<Carta> mazo) {
        System.out.println("nueva partida");
        for (Jugador j:jugadores) {
            repartir(j,mazo,3);
        }
        while(!determinarGanadores(jugadores)){
            System.out.println("Ingresa si deseas sacar una nueva carta");
            //...
        }

    }

    private static boolean determinarGanadores(ArrayList<Jugador> jugadores) {
        boolean ganador = false;
        for (Jugador j: jugadores) {
            if(j.calcularPuntos()==20){
                ganador=true;
                j.ganarPartida();
                System.out.println("ganador de partida = " + j);
            }
        }
        return ganador;
    }

    private static void determinarJugadores(ArrayList<Jugador> jugadores) {
        Scanner teclado = new Scanner(System.in);
        int nJugadores = 0;

        do{
            try {
                System.out.println("Ingresa la cantidad de Jugadores");
                nJugadores =teclado.nextInt();
            }catch (Exception e){
                teclado.next();
                System.out.println("Numero no valido");
            }
        }while(nJugadores<2);

        for (int i = 0; i < nJugadores; i++) {
            System.out.println("Ingresa el nombre del jugador");
            String nombre = teclado.next();
            jugadores.add(new Jugador(nombre));
        }
    }

    private static void repartir(Jugador jugador, ArrayList<Carta> cartas, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Carta c = cartas.get((int)(Math.random()*cartas.size()));
            jugador.addCarta(c);
            cartas.remove(c);
        }
    }

    private static void mostrarCartas(ArrayList<Carta> cartas) {
        for (Carta c:cartas) {
            System.out.println(c);
        }
    }

    private static void generadorCartas(ArrayList<Carta> mazo) {
        String[] pintas = {"Corazon", "Trebol", "Pica", "Diamante"};
        String[] simbolos = {"a", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] puntos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        for (int i = 0; i < pintas.length; i++) {
            for (int j = 0; j < simbolos.length; j++) {
                mazo.add(new Carta(pintas[i],simbolos[j],puntos[j]));
            }
        }

    }
}
