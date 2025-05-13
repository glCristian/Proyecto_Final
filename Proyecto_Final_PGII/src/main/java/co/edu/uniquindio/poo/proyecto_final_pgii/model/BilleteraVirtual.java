package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BilleteraVirtual {

    private static BilleteraVirtual instancia;

    private Collection<Persona> perfiles;
    private Collection<Cuenta> cuentas;
    private Collection<Transaccion> transacciones;

    public BilleteraVirtual() {
        this.perfiles = new LinkedList<>();
        this.cuentas = new LinkedList<>();
        this.transacciones = new LinkedList<>();
    }

    public static BilleteraVirtual getInstancia() {
        if (instancia == null) {
            instancia = new BilleteraVirtual();
        }
        return instancia;
    }


    public Collection<Persona> getPerfiles() {
        return perfiles;
    }

    public Collection<Cuenta> getCuentas() {
        return cuentas;
    }


    public Collection<Transaccion> getTransacciones() {
        return transacciones;
    }


}
