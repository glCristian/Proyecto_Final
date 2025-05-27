package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.Stack;

/**
 * Clase GestorComandos que implementa el patron command.
 * Funciona como invocador, manteniendo un historial de comando ejecutados
 * y permitiendo deshacer la ultima accion realizada.
 * Se utiliza el patron singleton para garantizar una unica instancia global que centraliza
 * la gestion de comando en toda la aplicacion
 */
public class GestorComandos {

    private Stack<Comando> historial; // Pila que almacena el historial de comando ejecutados
    private static GestorComandos instancia;

    /**
     * Constructor de la clase GetsorComandos
     */
    private GestorComandos() {
        this.historial = new Stack<>();
    }

    /**
     * Metodo que retorna la instancia unida de gestorComandos, si no existe la crea
     * @return
     */
    public static GestorComandos getInstancia() {
        if (instancia == null) {
            instancia = new GestorComandos();
        }
        return instancia;
    }


    /**
     * Ejecuta un comando, lo añade al historial y muestra su descripcion
     * @param comando
     */
    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        historial.push(comando);
        System.out.println(" Comando guardado en historial: " + comando.getDescripcion());
    }

    /**
     * Deshace el ultimo comando ejecutado si hay alguno en el historial
     */
    public void deshacerUltimoComando() {
        if (!historial.isEmpty()) {
            Comando ultimoComando = historial.pop();
            ultimoComando.deshacer();
            System.out.println(" Comando deshecho: " + ultimoComando.getDescripcion());
        } else {
            System.out.println(" No hay comandos para deshacer");
        }
    }


    /**
     * Muestra por consola el historial de comando ejecutados
     */
    public void mostrarHistorial() {
        System.out.println(" HISTORIAL DE COMANDOS:");
        if (historial.isEmpty()) {
            System.out.println("Sin comandos ejecutados");
            return;
        }

        for (int i = historial.size() - 1; i >= 0; i--) {
            System.out.println((historial.size() - i) + ". " + historial.get(i).getDescripcion());
        }
    }


    /**
     * Retorna la cantidad de comando almacenados en el historial
     * @return
     */
    public int getTamañoHistorial() {
        return historial.size();
    }
}
