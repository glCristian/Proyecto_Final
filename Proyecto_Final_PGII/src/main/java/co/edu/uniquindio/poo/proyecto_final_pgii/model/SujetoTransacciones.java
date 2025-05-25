package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Sujeto observable que notifica sobre transacciones
 */
public class SujetoTransacciones {

    private List<ObservadorTransacciones> observadores;

    public SujetoTransacciones() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(ObservadorTransacciones observador) {
        observadores.add(observador);
    }

    public void removerObservador(ObservadorTransacciones observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(Transaccion transaccion, String tipoEvento) {
        for (ObservadorTransacciones observador : observadores) {
            observador.notificarTransaccion(transaccion, tipoEvento);
        }
    }
}
