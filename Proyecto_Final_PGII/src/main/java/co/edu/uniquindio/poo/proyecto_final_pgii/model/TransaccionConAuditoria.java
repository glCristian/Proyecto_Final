package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import java.time.LocalDateTime;

/**
 * Decorador que agregar auditoria a las transacciones
 */
public class TransaccionConAuditoria extends TransaccionDecorator{

    private String usuarioAuditor;
    private LocalDateTime fechaAuditoria;

    public TransaccionConAuditoria(Transaccion transaccion, String usuarioAuditor) {
        super(transaccion);
        this.usuarioAuditor = usuarioAuditor;
        this.fechaAuditoria = LocalDateTime.now();
    }

    @Override
    public void mostrarTransaccion() {
        System.out.println("=== TRANSACCIÓN CON AUDITORÍA ===");
        super.mostrarTransaccion();
        System.out.println("Auditada por: " + usuarioAuditor);
        System.out.println("Fecha de auditoría: " + fechaAuditoria);
    }

    public String getUsuarioAuditor() { return usuarioAuditor; }
    public LocalDateTime getFechaAuditoria() { return fechaAuditoria; }
}
