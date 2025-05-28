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
    
    private Transaccion transaccionSeleccionada;
    private Cuenta cuentaSeleccionada;
    private Usuario usuarioSeleccionado;
    private Presupuesto presupuestoSeleccionado;

    /**
     * Constructir privado de la clase DatosCompartidos
     */
    private DatosCompartidos(){
    }

    /**
     * Metodo que retorna la instancia unica de DatosCompartidos, si no existe la crea
     * @return
     */
    public static DatosCompartidos getInstancia(){
        if (instancia == null){
            instancia = new DatosCompartidos();
        }
        return instancia;
    }

    /**
     * Metodo que obtiene el usuario seleccionado
     * @return
     */
    public Usuario getUsuarioSeleccionado(){
        return usuarioSeleccionado;
    }

    /**
     * Metodo que establece el usuario seleccionado
     * @param usuarioSeleccionado
     */
    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado){
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    /**
     * Metodo que obtiene la cuenta seleccionada
     * @return
     */
    public Cuenta getCuentaSeleccionada(){
        return cuentaSeleccionada;
    }

    /**
     * Metodo que establece la cuenta seleccionada
     * @param cuentaSeleccionada
     */
    public void setCuentaSeleccionada(Cuenta cuentaSeleccionada){
        this.cuentaSeleccionada = cuentaSeleccionada;
    }

    /**
     * Metodo que obtiene el presupuesto seleccionado
     * @return
     */
    public Presupuesto getPresupuestoSeleccionado() {
        return presupuestoSeleccionado;
    }

    /**
     * Metodo que establece el presupuesto seleccionado
     * @param presupuestoSeleccionado
     */
    public void setPresupuestoSeleccionado(Presupuesto presupuestoSeleccionado) {
        this.presupuestoSeleccionado = presupuestoSeleccionado;
    }
    
    /**
     * Metodo que obtiene la transaccion seleccionada
     * @return
     */
    public Transaccion getTransaccionSeleccionada() {
        return transaccionSeleccionada;
    }

    /**
     * Metodo que establece la transaccion seleccionada
     * @param transaccionSeleccionada
     */
   public void setTransaccionSeleccionada(Transaccion transaccionSeleccionada) {
        this.transaccionSeleccionada = transaccionSeleccionada;
    }
    
    
    
    

    /**
     * Limpia todos los datos almacenados en esta instancia
     * Util para reiniciar el estado compartido
     */
    public void limpiarDatosCompartidos() {
        this.cuentaSeleccionada = null;
        this.usuarioSeleccionado = null;
        this.presupuestoSeleccionado = null;
        this.transaccionSeleccionada = null;
    }

    /**
     * Limpia solo el usuario seleccionado
     */
    public void limpiarUsuarioSeleccionado() {
        this.usuarioSeleccionado = null;
    }

    /**
     * Limpia solo la cuenta seleccionada
     */
    public void limpiarCuentaSeleccionada() {
        this.cuentaSeleccionada = null;
    }

    /**
     * Limpia solo el presupuesto seleccionado
     */
    public void limpiarPresupuestoSeleccionado() {
        this.presupuestoSeleccionado = null;
    }

    /**
     * Limpia solo la transaccion seleccionada
     */
    public void limpiarTransaccionSeleccionada() {
        this.transaccionSeleccionada = null;
    }
}
