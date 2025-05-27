package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;

public class GestorCuentas {
    private static GestorCuentas instancia;

    private GestorCuentas() {
    }

    public static GestorCuentas getInstancia() {
        if (instancia == null) {
            instancia = new GestorCuentas();
        }
        return instancia;
    }

    /**
     * Metodo para crear y agregar una nueva cuenta
     */
    public void crearCuenta(String idCuenta, String nombreBanco, String numeroCuenta, 
                            TipoCuenta tipoCuenta) {
        Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();
        if (usuario != null) {
            Cuenta nuevaCuenta = new Cuenta(idCuenta, nombreBanco, numeroCuenta, tipoCuenta);
            usuario.agregarCuenta(nuevaCuenta);
            BilleteraVirtual.getInstancia().getCuentas().add(nuevaCuenta);
        }
    }

    /**
     * Metodo para eliminar una cuenta
     */
    public void eliminarCuenta(String idCuenta) {
        Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();
        if (usuario != null) {
            usuario.eliminarCuenta(idCuenta);
            BilleteraVirtual.getInstancia().getCuentas().removeIf(cuenta -> cuenta.getIdCuenta().equals(idCuenta));
        }
    }

    /**
     * Metodo para actualizar una cuenta
     */
    public void actualizarCuenta(String idCuenta, String nombreBanco, String numeroCuenta, 
                                TipoCuenta tipoCuenta) {
        Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();
        if (usuario != null) {
            for (Cuenta cuenta : usuario.getListaCuentas()) {
                if (cuenta.getIdCuenta().equals(idCuenta)) {
                    if (nombreBanco != null && !nombreBanco.isBlank()) 
                        cuenta.setNombreBanco(nombreBanco);
                    if (numeroCuenta != null && !numeroCuenta.isBlank()) 
                        cuenta.setNumeroCuenta(numeroCuenta);
                    if (tipoCuenta != null) 
                        cuenta.setTipoCuenta(tipoCuenta);
                    break;
                }
            }
        }
    }


    /**
     * Metodo para buscar una cuenta por su ID
     */
    public Cuenta obtenerCuentaUsuario(String idCuenta) {
        Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();
        if (usuario != null) {
            for (Cuenta cuenta : usuario.getListaCuentas()) {
                if (cuenta.getIdCuenta().equals(idCuenta)) {
                    return cuenta;
                }
            }
        }
        return null;
    }


    public void eliminarCuentagenerico(Cuenta cuenta) {
        if (cuenta == null) return;

        // 1. Eliminar de la lista de cuentas del usuario que la contiene
        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Usuario usuario) {
                usuario.getListaCuentas().removeIf(c -> c.getIdCuenta().equals(cuenta.getIdCuenta()));
            }
        }

        // 2. Eliminar de la lista global (si existe)
        BilleteraVirtual.getInstancia().getCuentas().removeIf(c -> c.getIdCuenta().equals(cuenta.getIdCuenta()));

        // 3. (Opcional) Eliminar transacciones relacionadas
        BilleteraVirtual.getInstancia().getTransacciones().removeIf(
                t -> cuenta.getIdCuenta().equals(t.getCuentaOrigen()) || cuenta.getIdCuenta().equals(t.getCuentaDestino())
        );
    }



}