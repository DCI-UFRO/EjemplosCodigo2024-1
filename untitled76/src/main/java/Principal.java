public class Principal {
    public static void main(String[] args) {
        // crear pokemones
        // crear maestros
        // crear equipos
        // luchar entre equipos

        Maestro m0 = new Maestro("Felipe");
        Maestro m1 = new Maestro("Lorenzo");

        Pokemon p0 = new Pokemon(4,"fuego","Charmander", 100);
        Pokemon p1 = new Pokemon(7,"agua","Squirtle", 100);
        m0.añadirPokemones(p0);
        m1.añadirPokemones(p1);

        m0.desafiar(m1);

    }

}
