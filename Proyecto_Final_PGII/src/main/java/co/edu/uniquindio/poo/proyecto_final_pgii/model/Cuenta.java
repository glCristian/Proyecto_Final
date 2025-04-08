package co.edu.uniquindio.poo.proyecto_final_pgii.model;


import java.util.Collection;
import java.util.LinkedList;

public class Cuenta {

    private String idCuenta;
    private String nombreBanco;
    private String numeroCuenta;
    private double saldoTotal;
    private TipoCuenta tipoCuenta;
    private Collection<Transaccion> listaTransacciones;

    /**
     * Constructor de la clase Cuenta
     * @param idCuenta
     * @param nombreBanco
     * @param numeroCuenta
     * @param saldoTotal
     * @param tipoCuenta
     */
    public Cuenta(String idCuenta, String nombreBanco, String numeroCuenta, double saldoTotal, TipoCuenta tipoCuenta) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.saldoTotal = saldoTotal;
        this.tipoCuenta = tipoCuenta;
        this.listaTransacciones = new LinkedList<>();
    }


    /**
     * Metodo que obtiene el ID de la cuenta
     * @return
     */
    public String getIdCuenta() {
        return idCuenta;
    }

    /**
     * Metodo que establece el ID de la cuenta
     * @param idCuenta
     */
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Metodo que obtiene el nombre del banco
     * @return
     */
    public String getNombreBanco() {
        return nombreBanco;
    }

    /**
     * Metodo que establece el nombre del banco
     * @param nombreBanco
     */
    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    /**
     * Metodo que obtiene el numero de la cuenta
     * @return
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Metodo que establece el numero de la cuenta
     * @param numeroCuenta
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Metodo que obtiene el saldo total de la cuenta
     * @return
     */
    public double getSaldoTotal() {
        return saldoTotal;
    }

    /**
     * Metodo que establece el saldo total de la cuenta
     * @param saldoTotal
     */
    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    /**
     * Metodo que obtiene el tipo de cuenta
     * @return
     */
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Metodo que establece el tipo de cuenta
     * @param tipoCuenta
     */
    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
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