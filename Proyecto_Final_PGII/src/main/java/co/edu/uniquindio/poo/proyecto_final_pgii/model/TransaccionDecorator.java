package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.time.LocalDateTime;

/**
 * Clase abstracta que implementa el patron decorator para la clase transaccion
 * Permite agregar funcionalidades adicionales a una transaccion sin modificar su estructura original
 */
public abstract class TransaccionDecorator {

    protected Transaccion transaccion; //Transaccion original que se esta decorando

    /**
     * Constructor de la clase TransaccionDecorator
     * @param transaccion
     */
    public TransaccionDecorator(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    /**
     * Muestra la informacion de la transaccion decorada
     */
    public void mostrarTransaccion() {
        transaccion.mostrarTransaccion();
    }

    /**
     * Metodo que obtiene el ID de la transaccion
     * @return
     */
    public String getIdTransaccion() {
        return transaccion.getIdTransaccion();
    }

    /**
     * Metodo que obtiene la fecha
     * @return
     */
    public LocalDateTime getFecha() {
        return transaccion.getFecha();
    }

    /**
     * Metodo que obtiene el monto
     * @return
     */
    public double getMonto() {
        return transaccion.getMonto();
    }

    /**
     * Metodo que obtiene la descripcion
     * @return
     */
    public String getDescripcion() {
        return transaccion.getDescripcion();
    }

    /**
     * Metodo que obtiene el tipo de transaccion
     * @return
     */
    public TipoTransaccion getTipoTransaccion() {
        return transaccion.getTipoTransaccion();
    }

}
