package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase central que representa el sistema de la billetera virtual
 * Implementa el patron singleton para garantizar una unica instancia global
 */
public class BilleteraVirtual {

    private static BilleteraVirtual instancia;

    private Collection<Persona> perfiles;
    private Collection<Cuenta> cuentas;
    private Collection<Transaccion> transacciones;

    /**
     * Constructor de la clase Billetera Virtual
     */
    public BilleteraVirtual() {
        this.perfiles = new LinkedList<>();
        this.cuentas = new LinkedList<>();
        this.transacciones = new LinkedList<>();
    }

    /**
     * Metodo que retorna la instancia unica de la billetera virtial, si no existe la crea
     * @return
     */
    public static BilleteraVirtual getInstancia() {
        if (instancia == null) {
            instancia = new BilleteraVirtual();
        }
        return instancia;
    }


    /**
     * Metodo que obtiene la coleccion de perfiles registrados
     * @return
     */
    public Collection<Persona> getPerfiles() {
        return perfiles;
    }

    /**
     * Metodo que obtiene la coleccion de cuentas registradss
     * @return
     */
    public Collection<Cuenta> getCuentas() {
        return cuentas;
    }

    /**
     * Metodo que obtiene la coleccion de transacciones realizadas
     * @return
     */
    public Collection<Transaccion> getTransacciones() {
        return transacciones;
    }


}
