package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorTransacciones;

/**
 * Comando que representa una transferencia de dinero entre dos cuentas
 * Implementa el patron command permitiendo ejecutar y deshacer la transferencia
 */
public class ComandoTransferencia implements Comando{

    private String cuentaOrigen;
    private String cuentaDestino;
    private double monto;
    private String descripcion;
    private Categoria categoria;
    private boolean ejecutado;

    /**
     * Constructor de la clase ComandoTransferencia
     * @param cuentaOrigen
     * @param cuentaDestino
     * @param monto
     * @param descripcion
     * @param categoria
     */
    public ComandoTransferencia(String cuentaOrigen, String cuentaDestino,
                                double monto, String descripcion, Categoria categoria) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ejecutado = false;
    }


    /**
     * Metodo que ejecuta la transferencia realizando el movimiento de dinero desde la cuenta origen
     * a la cuenta destino usando el gestorTrnasacciones
     */
    @Override
    public void ejecutar() {
        if (!ejecutado) {
            boolean exito = GestorTransacciones.getInstancia()
                    .realizarTransferencia(cuentaOrigen, cuentaDestino, monto, descripcion, categoria);
            if (exito) {
                ejecutado = true;
                System.out.println(" Transferencia ejecutada: $" + monto);
            }
        }
    }

    /**
     * Metodo que deshace la transferencia realizando una transferencia inversa desde la cuenta destino
     * hacia la cuenta origen para revertir el movimiento anterior
     */
    @Override
    public void deshacer() {
        if (ejecutado) {
            // Transferencia inversa para deshacer
            boolean exito = GestorTransacciones.getInstancia()
                    .realizarTransferencia(cuentaDestino, cuentaOrigen, monto,
                            "REVERSA: " + descripcion, categoria);
            if (exito) {
                ejecutado = false;
                System.out.println(" Transferencia deshecha: $" + monto);
            }
        }
    }

    /**
     * Metodo que devuelve una descripcion de la transferencia indicando el monto, cuenta origen y destino
     * @return
     */
    @Override
    public String getDescripcion() {
        return "Transferencia de $" + monto + " de " + cuentaOrigen + " a " + cuentaDestino;
    }
}
