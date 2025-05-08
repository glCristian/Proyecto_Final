package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BilleteraVirtual {

    private static BilleteraVirtual instancia;

    private Administrador administrador;
    private Collection<Usuario> usuarios;
    private Collection<Cuenta> cuentas;
    private Collection<Transaccion> transacciones;

    public BilleteraVirtual() {
        this.usuarios = new LinkedList<>();
        this.cuentas = new LinkedList<>();
        this.transacciones = new LinkedList<>();
    }

    private BilleteraVirtual getInstancia() {
        if (instancia == null) {
            instancia = new BilleteraVirtual();
        }
        return instancia;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Collection<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(Collection<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Collection<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Collection<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
}
