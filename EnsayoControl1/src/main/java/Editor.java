public class Editor {

    private String nombre;
    private String rut;
    private String  tematica;

    public Editor(String nombre, String rut, String tematica) {
        this.nombre = nombre;
        this.rut = rut;
        this.tematica = tematica;
    }

    public Editor() {
        this.nombre = ingresarNombre();
        this.tematica = ingresarTematica();
        this.rut = ingresarRut();
    }

    private String ingresarRut() {
        return "---";
    }

    private String ingresarTematica() {
        return "---";
    }

    private String ingresarNombre() {
        return "---";
    }
}
