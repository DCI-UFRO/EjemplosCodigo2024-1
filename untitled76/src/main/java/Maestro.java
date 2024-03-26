import java.util.ArrayList;

public class Maestro {
    private static final int LIMITEEQUIPO = 6;
    private String nombre;
    private ArrayList<Pokemon> equipo;

    public Maestro(String nombre) {
        this.nombre = nombre;
        equipo= new ArrayList<>();
    }

    public Maestro(String nombre, Pokemon pokemon) {
        this.nombre = nombre;
        equipo = new ArrayList<>();
        añadirPokemones(pokemon);
    }

    public void añadirPokemones(Pokemon pokemon) {
        if(equipo.size()<LIMITEEQUIPO){
            equipo.add(pokemon);
        }
    }


    public void desafiar(Maestro m) {
        boolean hayPokemon = false;
        Pokemon p0 = null;
        for (int i = 0; i < this.equipo.size(); i++) {
            if(!this.equipo.get(i).isFainted()){
                p0=this.equipo.get(i);
                hayPokemon = true;
            }
        }
        if(!hayPokemon){
            System.out.println(this.nombre + " se quedo sin pokemones");
        }

        hayPokemon=false;
        Pokemon p1 = null;
        for (int i = 0; i < m.equipo.size(); i++) {
            if(!m.equipo.get(i).isFainted()){
                p1=m.equipo.get(i);
                hayPokemon=true;
            }
        }
        if(!hayPokemon){
            System.out.println(m.nombre + " se quedo sin pokemones");
        }
        if(hayPokemon){
            lucha(p0,p1);
        }else{
            System.out.println("no hay pokemones para luchar");
        }
    }

    public void lucha(Pokemon p0, Pokemon p1){
        while(true){
            p0.luchar(p1);
            if(p1.isFainted())
                break;
            p1.luchar(p0);
            if(p0.isFainted())
                break;
            System.out.println(p0);
            System.out.println(p1);
        }
        System.out.println(p0);
        System.out.println(p1);
    }
}
