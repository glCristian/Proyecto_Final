package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Sujeto observable que gestiona una lista de observadores interesados en eventos de transacciones
 *
 * Permite agregar, remover y notificar a los observadores cuando ocurre un evento relacionado con una transaccion.
 * Implementa el patron observer para mantener a los observadores informados automaticamente
 */
public class SujetoTransacciones {

    private List<ObservadorTransacciones> observadores;

    /**
     * Constructor de la clase SujetoTransacciones
     */
    public SujetoTransacciones() {
        this.observadores = new ArrayList<>();
    }


    /**
     * Agrega un observador a la lista para recibir notificaciones
     * @param observador
     */
    public void agregarObservador(ObservadorTransacciones observador) {
        observadores.add(observador);
    }

    /**
     * Remueve un observador de la lista para dejar de recibir notificacionnes
     * @param observador
     */
    public void removerObservador(ObservadorTransacciones observador) {
        observadores.remove(observador);
    }


    /**
     * Notifica a todos los observadores registrados sobre un evento relacionado con una transaccion
     * @param transaccion
     * @param tipoEvento
     */
    public void notificarObservadores(Transaccion transaccion, String tipoEvento) {
        for (ObservadorTransacciones observador : observadores) {
            observador.notificarTransaccion(transaccion, tipoEvento);
        }
    }
}
