package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Interfaz del patron Observser que define el contrato para los observadores de transacciones.
 * Permite que los objetos que implementan esta interfaz sean notificados automaticamente
 * Cuando courre un evento relacionado con una transaccion
 */
public interface ObservadorTransacciones {

    /**
     * Metodo que se ejecuta cuando ocurre un evento relacionado con una transaccion
     * @param transaccion
     * @param tipoEvento
     */
    void notificarTransaccion(Transaccion transaccion, String tipoEvento);
}
