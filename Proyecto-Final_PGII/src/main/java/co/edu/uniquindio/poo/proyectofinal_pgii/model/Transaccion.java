package co.edu.uniquindio.poo.proyectofinal_pgii.model;

public class Transaccion {

    private String idTransaccion;
    private String fecha;
    private double monto;
    private String descripcion;
    private String cuentaOrigen;
    private String cuentaDestino;
    private Categoria categoria;
    private TipoTransaccion tipoTransaccion;

    /**
     * Constructor de la clase Transaccion
     * @param idTransaccion
     * @param fecha
     * @param monto
     * @param descripcion
     * @param cuentaOrigen
     * @param cuentaDestino
     * @param categoria
     * @param tipoTransaccion
     */
    public Transaccion(String idTransaccion, String fecha, double monto, String descripcion, String cuentaOrigen, String cuentaDestino, Categoria categoria, TipoTransaccion tipoTransaccion) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.categoria = categoria;
        this.tipoTransaccion = tipoTransaccion;
    }


    /**
     * Metodo que obtiene el ID de una transaccion
     * @return
     */
    public String getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Metodo que establece el ID de una transaccion
     * @param idTransaccion
     */
    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * Metodo que obtiene la fecha de una transaccion
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Metodo que establece la fecha de una transaccion
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo que obtiene el monto de una transaccion
     * @return
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Metodo que establece el monto de una transaccion
     * @param monto
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Metodo que obtiene la descripcion de una transaccion
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo que establece la descripcion de una transaccion
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo que obtiene la cuenta de origen de una transaccion
     * @return
     */
    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    /**
     * Metodo que establece la cuenta de origen de una transaccion
     * @param cuentaOrigen
     */
    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    /**
     * Metodo que obtiene la cuenta de destino de una transaccion
     * @return
     */
    public String getCuentaDestino() {
        return cuentaDestino;
    }

    /**
     * Metodo que establece la cuenta de destino de una transaccion
     * @param cuentaDestino
     */
    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    /**
     * Metodo que obtiene la categoria de una transaccion
     * @return
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Metodo que establece la categoria de una transaccion
     * @param categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Metodo que obtiene de tipo de transaccion
     * @return
     */
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * Metodo que establece de tipo de transaccion
     * @param tipoTransaccion
     */
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
}
