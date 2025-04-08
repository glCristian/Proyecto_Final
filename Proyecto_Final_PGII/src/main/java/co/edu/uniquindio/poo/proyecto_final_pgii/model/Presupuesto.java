package co.edu.uniquindio.poo.proyecto_final_pgii.model;


public class Presupuesto {

    private String idPresupuesto;
    private String nombre;
    private double montoTotal;
    private double montoGastado;
    private Categoria categoria;

    /**
     * Constructor de la clase Presupuesto
     * @param idPresupuesto
     * @param nombre
     * @param montoTotal
     * @param montoGastado
     * @param categoria
     */
    public Presupuesto(String idPresupuesto, String nombre, double montoTotal, double montoGastado, Categoria categoria) {
        this.idPresupuesto = idPresupuesto;
        this.nombre = nombre;
        this.montoTotal = montoTotal;
        this.montoGastado = montoGastado;
        this.categoria = categoria;
    }


    /**
     * Metodo que obtiene el ID del un presupuesto
     * @return
     */
    public String getIdPresupuesto() {
        return idPresupuesto;
    }

    /**
     * Metodo que establece el ID del un presupuesto
     * @param idPresupuesto
     */
    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    /**
     * Metodo que obtiene el nombre de un presupuesto
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre de un presupuesto
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el monto total de un presupuesto
     * @return
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * Metodo que establece el monto total de un presupuesto
     * @param montoTotal
     */
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * Metodo que obtiene el monto gastado de un presupuesto
     * @return
     */
    public double getMontoGastado() {
        return montoGastado;
    }

    /**
     * Metodo que establece el monto gastado de un presupuesto
     * @param montoGastado
     */
    public void setMontoGastado(double montoGastado) {
        this.montoGastado = montoGastado;
    }

    /**
     * Metodo que obtiene la categoria de un presupuesto
     * @return
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Metodo que establece la categoria de un presupuesto
     * @param categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}