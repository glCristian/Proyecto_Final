package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class GestorTransacciones {

    private static GestorTransacciones instancia;

    private GestorTransacciones(){}

    public static GestorTransacciones getInstancia(){
        if(instancia == null){
            instancia = new GestorTransacciones();
        }
        return instancia;
    }

    /**
     * Metodo que genera un ID de manera aleatoria
     * @return idUnico
     */
    public static String generarIdUnico() {
        return UUID.randomUUID().toString().substring(0, 8);
    }


    /**
     * Metodo que obtiene la fecha actual y la devuelve como String
     * @return fecha Actual
     */
    public static LocalDateTime obtenerFechaActual() {
        return LocalDateTime.now();
    }




    public Cuenta buscarCuentaPorId(String idCuenta) {
        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Usuario usuario) {
                for (Cuenta cuenta : usuario.getListaCuentas()) {
                    if (cuenta.getIdCuenta().equals(idCuenta)) {
                        return cuenta;
                    }
                }
            }
        }
        return null;
    }


    /**
     * Metodo para realizar un depósito
     */
    public boolean depositarDinero(String idCuenta, double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return false;
        }

        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Usuario usuario) {
                for (Cuenta cuenta : usuario.getListaCuentas()) {
                    if (cuenta.getIdCuenta().equals(idCuenta)) {
                        cuenta.depositar(monto);
                        return true;
                    }
                }
            }
        }

        System.out.println("Cuenta no encontrada para depósito.");
        return false;
    }


    /**
     * Metodo para realizar un retiro
     */
    public boolean retirarDinero(String idCuenta, double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return false;
        }

        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Usuario usuario) {
                for (Cuenta cuenta : usuario.getListaCuentas()) {
                    if (cuenta.getIdCuenta().equals(idCuenta)) {
                        if (cuenta.getSaldoTotal() >= monto) {
                            cuenta.retirar(monto);
                            return true;
                        } else {
                            System.out.println("Saldo insuficiente en la cuenta.");
                            return false;
                        }
                    }
                }
            }
        }

        System.out.println("Cuenta no encontrada para retiro.");
        return false;
    }



    public boolean realizarTransferencia(String idCuentaOrigen, String idCuentaDestino, double monto,
                                         String descripcion, Categoria categoria) {
        if (retirarDinero(idCuentaOrigen, monto) && depositarDinero(idCuentaDestino, monto)) {
            Transaccion t = Transaccion.crearTransferencia(idCuentaOrigen, idCuentaDestino, monto, descripcion, categoria);
            registrarTransaccion(t);
            return true;
        }
        return false;
    }

    public boolean realizarDeposito(String idCuentaDestino, double monto, String descripcion, Categoria categoria) {
        if (depositarDinero(idCuentaDestino, monto)) {
            Transaccion t = Transaccion.crearDeposito(idCuentaDestino, monto, descripcion, categoria);
            registrarTransaccion(t);
            return true;
        }
        return false;
    }

    public boolean realizarRetiro(String idCuentaOrigen, double monto, String descripcion, Categoria categoria) {
        if (retirarDinero(idCuentaOrigen, monto)) {
            Transaccion t = Transaccion.crearRetiro(idCuentaOrigen, monto, descripcion, categoria);
            registrarTransaccion(t);
            return true;
        }
        return false;
    }

    private void registrarTransaccion(Transaccion t) {
        if (t == null) return;

        // Añadir a la cuenta origen si aplica
        if (t.getCuentaOrigen() != null) {
            Cuenta cuentaOrigen = buscarCuentaPorId(t.getCuentaOrigen());
            if (cuentaOrigen != null) {
                cuentaOrigen.getListaTransacciones().add(t);
            }
        }

        // Añadir a la cuenta destino si aplica y es distinta
        if (t.getCuentaDestino() != null && !t.getCuentaDestino().equals(t.getCuentaOrigen())) {
            Cuenta cuentaDestino = buscarCuentaPorId(t.getCuentaDestino());
            if (cuentaDestino != null) {
                cuentaDestino.getListaTransacciones().add(t);
            }
        }

        // Registro global
        BilleteraVirtual.getInstancia().getTransacciones().add(t);
    }


}
