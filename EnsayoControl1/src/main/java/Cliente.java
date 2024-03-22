public class Cliente {
    private String rut;
    private String nombre;
    private String telefono;

    public Cliente(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = "";
    }

    public Cliente(String rut, String nombre, String telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente(String opcion) {
        this.rut = ingresarRut();
        this.nombre = ingresarNombre();
        switch (opcion){
            case "empresa":
                telefono = ingresarTelefono();
                break;
            case "persona":
                telefono = "";
                break;
        }
    }

    private String ingresarTelefono() {
        return "---";
    }

    private String ingresarRut() {
        return "---";
    }

    private String ingresarNombre() {
        return "---";
    }

}
