package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.time.LocalDateTime;

/**
 * Patron decorator, Permite agregar funcionalidades a las trasacciones sin modificadar su estructura
 */
public abstract class TransaccionDecorator {

    protected Transaccion transaccion;

    public TransaccionDecorator(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public void mostrarTransaccion() {
        transaccion.mostrarTransaccion();
    }

    public String getIdTransaccion() { return transaccion.getIdTransaccion(); }
    public LocalDateTime getFecha() { return transaccion.getFecha(); }
    public double getMonto() { return transaccion.getMonto(); }
    public String getDescripcion() { return transaccion.getDescripcion(); }
    public TipoTransaccion getTipoTransaccion() { return transaccion.getTipoTransaccion(); }

}
