package co.edu.uniquindio.poo.proyecto_final_pgii.model;


import java.util.Collection;
import java.util.LinkedList;

public class Movimiento {

    private String idMovimiento;
    private Collection<Transaccion> listaTransacciones;

    /**
     * Constructor de la clase Movimiento
     * @param idMovimiento
     */
    public Movimiento(String idMovimiento) {
        this.idMovimiento = idMovimiento;
        this.listaTransacciones = new LinkedList<>();
    }

    /**
     * Metodo que obtiene el ID del movimiento
     * @return
     */
    public String getIdMovimiento() {
        return idMovimiento;
    }

    /**
     * Metodo que establece el ID del movimiento
     * @param idMovimiento
     */
    public void setIdMovimiento(String idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    /**
     * Metodo que obtiene las transacciones
     * @return
     */
    public Collection<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    /**
     * Metodo que establece las transacciones
     * @param listaTransacciones
     */
    public void setListaTransacciones(Collection<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }
}