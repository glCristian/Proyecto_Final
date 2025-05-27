package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Decorador que agregar funcionalidad de encriptacion a una transaccion
 */
public class TransaccionEncriptada extends TransaccionDecorator{

    private boolean esEncriptada;

    /**
     * Constructor de la clase TransaccionEncriptada
     * @param transaccion
     */
    public TransaccionEncriptada(Transaccion transaccion) {
        super(transaccion);
        this.esEncriptada = false;
    }

    /**
     * Marca la transaccion como encriptada
     */
    public void encriptar() {
        this.esEncriptada = true;
        System.out.println("Transacción " + transaccion.getIdTransaccion() + " ha sido encriptada");
    }

    /**
     * Marca la transaccion como descencriptada
     */
    public void desencriptar() {
        this.esEncriptada = false;
        System.out.println("Transacción " + transaccion.getIdTransaccion() + " ha sido desencriptada");
    }

    /**
     * Muestra la informacion de la transaccion
     */
    @Override
    public void mostrarTransaccion() {
        if (esEncriptada) {
            System.out.println("=== TRANSACCIÓN ENCRIPTADA ===");
            System.out.println("ID: [ENCRIPTADO]");
            System.out.println("Monto: [ENCRIPTADO]");
            System.out.println("Descripción: [ENCRIPTADO]");
        } else {
            System.out.println("=== TRANSACCIÓN SEGURA ===");
            super.mostrarTransaccion();
        }
    }

    /**
     * Indica si la transaccion esta actualmente escriptada
     * @return
     */
    public boolean isEncriptada() {
        return esEncriptada;
    }
}
