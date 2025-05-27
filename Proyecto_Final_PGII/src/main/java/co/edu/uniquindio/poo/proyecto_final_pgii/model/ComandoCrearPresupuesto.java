package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Comando para crear un presupuesto en la lista de presupuestos de un usuario
 * Implementa el patron command permitiendo ejecutar y deshacer la creacion de un presupuesto
 */
public class ComandoCrearPresupuesto implements Comando{

    private Presupuesto presupuesto;
    private Usuario usuario;
    private boolean ejecutado;

    /**
     * Constructor de la clase ComandoCrearPresupuesto
     * @param presupuesto
     * @param usuario
     */
    public ComandoCrearPresupuesto(Presupuesto presupuesto, Usuario usuario) {
        this.presupuesto = presupuesto;
        this.usuario = usuario;
        this.ejecutado = false;
    }


    /**
     * Metodo que ejecuta lacreacion del presupuesto, añadiendolo a la lista de presupuestos del usuario
     */
    @Override
    public void ejecutar() {
        if (!ejecutado) {
            usuario.getListaPresupuestos().add(presupuesto);
            ejecutado = true;
            System.out.println(" Presupuesto creado: " + presupuesto.getNombre());
        }
    }

    /**
     * Metodo que deshace la creacion eliminando el presupuesto de la lista del usuario
     */
    @Override
    public void deshacer() {
        if (ejecutado) {
            usuario.getListaPresupuestos().remove(presupuesto);
            ejecutado = false;
            System.out.println(" Presupuesto eliminado: " + presupuesto.getNombre());
        }
    }

    /**
     * Metodo que devuelve una descripcion del comando indicando el nombre y monto asignado al presupuesto
     * @return
     */
    @Override
    public String getDescripcion() {
        return "Crear presupuesto: " + presupuesto.getNombre() + " ($" + presupuesto.getMontoAsignado() + ")";
    }
}
