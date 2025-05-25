package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorTransacciones;

public class ComandoTransferencia implements Comando{

    private String cuentaOrigen;
    private String cuentaDestino;
    private double monto;
    private String descripcion;
    private Categoria categoria;
    private boolean ejecutado;

    public ComandoTransferencia(String cuentaOrigen, String cuentaDestino,
                                double monto, String descripcion, Categoria categoria) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ejecutado = false;
    }

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

    @Override
    public String getDescripcion() {
        return "Transferencia de $" + monto + " de " + cuentaOrigen + " a " + cuentaDestino;
    }
}
