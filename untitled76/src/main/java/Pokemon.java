public class Pokemon {

    private int numero;
    private String tipo;
    private String nombre;
    private int hp;
    private boolean fainted;

    public Pokemon(int numero, String tipo, String nombre, int hp) {
        this.numero = numero;
        this.tipo = tipo;
        this.nombre = nombre;
        this.hp = hp;
        this.fainted = false;
    }

    public void luchar(Pokemon p) {
        int daño = (int)(Math.random()*40);
        p.daño(daño);
    }

    private void daño(int daño) {
        if(hp-daño<0){
            daño = hp;
        }
        this.hp-=daño;
        if(hp==0){
            fainted=true;
        }
    }

    public boolean isFainted() {
        return fainted;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", hp=" + hp +
                '}';
    }
}
