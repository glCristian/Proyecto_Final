package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.time.LocalDateTime;

/**
 * Decorador que agregar funcionalidad de auditoria a una transaccion
 * Permite registrar el usuario que realiza la auditoria y la fecha en que se realizo
 */
public class TransaccionConAuditoria extends TransaccionDecorator{

    private String usuarioAuditor;
    private LocalDateTime fechaAuditoria;

    /**
     * Constructor de la clase TransaccionConAuditoria
     * @param transaccion
     * @param usuarioAuditor
     */
    public TransaccionConAuditoria(Transaccion transaccion, String usuarioAuditor) {
        super(transaccion);
        this.usuarioAuditor = usuarioAuditor;
        this.fechaAuditoria = LocalDateTime.now();
    }

    /**
     * Muestra la informacion completa de la transaccion decorada
     */
    @Override
    public void mostrarTransaccion() {
        System.out.println("=== TRANSACCIÓN CON AUDITORÍA ===");
        super.mostrarTransaccion();
        System.out.println("Auditada por: " + usuarioAuditor);
        System.out.println("Fecha de auditoría: " + fechaAuditoria);
    }

    /**
     * Obtiene el usuaeio que relizo la auditoria
     * @return
     */
    public String getUsuarioAuditor() { return usuarioAuditor; }

    /**
     * Obtiene la fecha y hora en que se realizo la auditoria
     * @return
     */
    public LocalDateTime getFechaAuditoria() { return fechaAuditoria; }
}
