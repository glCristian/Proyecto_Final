package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.Stack;

/**
 * Invocador que mantiene historial de comandos
 */
public class GestorComandos {

    private Stack<Comando> historial;
    private static GestorComandos instancia;

    private GestorComandos() {
        this.historial = new Stack<>();
    }

    public static GestorComandos getInstancia() {
        if (instancia == null) {
            instancia = new GestorComandos();
        }
        return instancia;
    }

    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        historial.push(comando);
        System.out.println("📝 Comando guardado en historial: " + comando.getDescripcion());
    }

    public void deshacerUltimoComando() {
        if (!historial.isEmpty()) {
            Comando ultimoComando = historial.pop();
            ultimoComando.deshacer();
            System.out.println(" Comando deshecho: " + ultimoComando.getDescripcion());
        } else {
            System.out.println(" No hay comandos para deshacer");
        }
    }

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

    public int getTamañoHistorial() {
        return historial.size();
    }
}
