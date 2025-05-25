package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Patron observer, permite notificar automaticamente a multiples observadores cuando ocurren eventos
 */
public interface ObservadorTransacciones {

    void notificarTransaccion(Transaccion transaccion, String tipoEvento);
}
