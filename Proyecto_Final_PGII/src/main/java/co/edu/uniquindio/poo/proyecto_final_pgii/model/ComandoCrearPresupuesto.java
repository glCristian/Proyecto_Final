package co.edu.uniquindio.poo.proyecto_final_pgii.model;

public class ComandoCrearPresupuesto implements Comando{

    private Presupuesto presupuesto;
    private Usuario usuario;
    private boolean ejecutado;

    public ComandoCrearPresupuesto(Presupuesto presupuesto, Usuario usuario) {
        this.presupuesto = presupuesto;
        this.usuario = usuario;
        this.ejecutado = false;
    }

    @Override
    public void ejecutar() {
        if (!ejecutado) {
            usuario.getListaPresupuestos().add(presupuesto);
            ejecutado = true;
            System.out.println(" Presupuesto creado: " + presupuesto.getNombre());
        }
    }

    @Override
    public void deshacer() {
        if (ejecutado) {
            usuario.getListaPresupuestos().remove(presupuesto);
            ejecutado = false;
            System.out.println(" Presupuesto eliminado: " + presupuesto.getNombre());
        }
    }

    @Override
    public String getDescripcion() {
        return "Crear presupuesto: " + presupuesto.getNombre() + " ($" + presupuesto.getMontoAsignado() + ")";
    }
}
