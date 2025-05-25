package co.edu.uniquindio.poo.proyecto_final_pgii.model;

/**
 * Decorador que agrega enciptacion a las transacciones
 */
public class TransaccionEncriptada extends TransaccionDecorator{

    private boolean esEncriptada;

    public TransaccionEncriptada(Transaccion transaccion) {
        super(transaccion);
        this.esEncriptada = false;
    }

    public void encriptar() {
        this.esEncriptada = true;
        System.out.println("Transacción " + transaccion.getIdTransaccion() + " ha sido encriptada");
    }

    public void desencriptar() {
        this.esEncriptada = false;
        System.out.println("Transacción " + transaccion.getIdTransaccion() + " ha sido desencriptada");
    }

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

    public boolean isEncriptada() {
        return esEncriptada;
    }
}
