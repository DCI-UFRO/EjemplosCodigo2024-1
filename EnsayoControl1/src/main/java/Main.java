/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 *
 * @author
 */
public class Main {
    //arreglos genericos
    //agrega/modifica los arreglos que encuentres necesarios
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Editor> editores = new ArrayList<>();

    public static void main(String[] args) {
        registrarEditor();

        do{
            registrarSolicitante();
            Editor e = seleccionarEditor();
            generarTrabajo(e);
        }while(nuevaTrabajo());
    }

    public static boolean nuevaTrabajo() {
        //metodo que preguntará si desea o no un nuevo trabajo
        return true;
    }

    public static void generarTrabajo(Editor e) {
        // metodo para generar el nuevo trabajo

        do{
            verCorreciones(/*trabajo*/);
        }while(true);

    }

    public static void registrarSolicitante() {
        //metodo para registrar al cliente/empresa
    }

    public static void registrarEditor() {
        // metodo para el registro de un nuevo editor
        editores.add(new Editor());

    }

    public static Editor seleccionarEditor() {
        //metodo para selecionar un editor existente en una lista, si no deberá crearse uno
        return editores.get(0);
    }

    public static void verCorreciones() {
        //metodo para modificar las correciones y determinar si el trabajo es publicado o no.
    }

}
