package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Clase para compartir datos entre diferentes controladores o vistas en la aplicacion
 *
 * Se usa para almacenar temporalmente una cuenta seleccionada en una vista
 * para luego ser accedida en otra vista o controlador
 *
 * el patron singleton es util porque proporciona un punto unico de acceso para el almacenamiento temporal
 * de datos
 *
 *
 */
public class DatosCompartidos {

    private static  DatosCompartidos instancia;
    private Cuenta cuentaSeleccionada;
    private Usuario usuarioSeleccionado;

    private DatosCompartidos(){
    }

    public static DatosCompartidos getInstancia(){
        if (instancia == null){
            instancia = new DatosCompartidos();
        }
        return instancia;
    }

    public Usuario getUsuarioSeleccionado(){
        return usuarioSeleccionado;
    }


    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado){
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public Cuenta getCuentaSeleccionada(){
        return cuentaSeleccionada;
    }

    public void setCuentaSeleccionada(Cuenta cuentaSeleccionada){
        this.cuentaSeleccionada = cuentaSeleccionada;
    }
}
