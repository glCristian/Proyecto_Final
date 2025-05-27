package co.edu.uniquindio.poo.proyecto_final_pgii.model;


public class Presupuesto {

    private String idPresupuesto;
    private String nombre;
    private double montoAsignado;
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
    public Presupuesto(String idPresupuesto, String nombre, double montoAsignado, double montoGastado, Categoria categoria) {
        this.idPresupuesto = idPresupuesto;
        this.nombre = nombre;
        this.montoAsignado = montoAsignado;
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
     * Metodo que obtiene el monto asignado de un presupuesto
     * @return
     */
    public double getMontoAsignado() {
        return montoAsignado;
    }

    /**
     * Metodo que establece el monto asignado de un presupuesto
     * @param montoAsignado
     */
    public void setMontoAsignado(double montoAsignado) {
        this.montoAsignado = montoAsignado;
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


    public void actualizarPresupuesto(double montoNuevo){
        this.montoAsignado = montoNuevo;
        System.out.println("Presupuesto actualizado a " + montoNuevo);
    }

    public String consultarEstado(){
        return "Presupuesto: " + nombre + "\nMonto Asignado: " + montoAsignado + "\nMonto Gastado: " + montoGastado;
    }

    public void agregarGasto(double monto) {
        montoGastado += monto;
        System.out.println("Gasto agregado de " + monto + " al presupuesto " + nombre);
    }


    @Override
    public String toString() {
        return "\n--- Presupuesto ---" +
                "\nID: " + idPresupuesto +
                "\nNombre: " + nombre +
                "\nMonto Asignado: $" + String.format("%,.2f", montoAsignado) +
                "\nMonto Gastado: $" + String.format("%,.2f", montoGastado) +
                "\nCategoría: " + (categoria != null ? categoria : "Sin categoría") +
                "\n-------------------";
    }

}