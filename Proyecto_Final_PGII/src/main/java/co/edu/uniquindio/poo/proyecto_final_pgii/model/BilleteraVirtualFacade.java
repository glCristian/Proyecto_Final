package co.edu.uniquindio.poo.proyecto_final_pgii.model;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorCuentas;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorPerfiles;
import co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores.GestorTransacciones;

import java.util.List;
import java.util.UUID;

/**
 * Clase que implementa el Patron facade
 * proporciona una interfaz simplificada para operaciones complejas del sistema
 */
public class BilleteraVirtualFacade {

    private GestorPerfiles gestorPerfiles;
    private GestorCuentas gestorCuentas;
    private GestorTransacciones gestorTransacciones;

    /**
     * Constructor que inicializa los gestores requeridos
     */
    public BilleteraVirtualFacade() {
        this.gestorPerfiles = GestorPerfiles.getInstancia();
        this.gestorCuentas = GestorCuentas.getInstancia();
        this.gestorTransacciones = GestorTransacciones.getInstancia();
    }

    /**
     * Metodo que realiza una Operación completa de transferencia con validaciones
     */
    public boolean realizarTransferenciaCompleta(String emailUsuario, String cuentaOrigen,
                                                 String cuentaDestino, double monto,
                                                 String descripcion, String nombreCategoria) {
        try {
            // 1. Validar usuario autenticado
            Usuario usuario = GestorSesion.getInstancia().getUsuarioActual();
            if (usuario == null || !usuario.getEmail().equals(emailUsuario)) {
                System.out.println("Usuario no autorizado para realizar la operación");
                return false;
            }

            // 2. Crear categoría automáticamente si no existe
            Categoria categoria = new Categoria(UUID.randomUUID().toString(), nombreCategoria, "");

            // 3. Realizar la transferencia
            boolean exitosa = gestorTransacciones.realizarTransferencia(
                    cuentaOrigen, cuentaDestino, monto, descripcion, categoria);

            // 4. Generar notificación automática
            if (exitosa) {
                generarNotificacionTransferencia(usuario, monto, cuentaDestino);
                System.out.println("Transferencia realizada exitosamente");
            }

            return exitosa;

        } catch (Exception e) {
            System.out.println("Error en la transferencia: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metodo para crear un nuevo usuario completo con cuenta inicial
     */
    public boolean crearUsuarioCompleto(String nombres, String apellidos, String email,
                                        String telefono, String direccion, String contrasena,
                                        String nombreBanco, String tipoCuenta) {
        try {
            // 1. Generar ID único
            String idUsuario = UUID.randomUUID().toString().substring(0, 8);

            // 2. Crear usuario usando Builder
            UsuarioBuilder builder = new UsuarioBuilder()
                    .setNombres(nombres)
                    .setApellidos(apellidos)
                    .setEmail(email)
                    .setTelefono(telefono)
                    .setDireccion(direccion)
                    .setIdUsuario(idUsuario)
                    .setContrasena(contrasena);

            // 3. Crear cuenta inicial si se especifica
            if (nombreBanco != null && !nombreBanco.isEmpty()) {
                String idCuenta = UUID.randomUUID().toString().substring(0, 8);
                String numeroCuenta = generarNumeroCuenta();
                TipoCuenta tipo = TipoCuenta.valueOf(tipoCuenta.toUpperCase());

                Cuenta cuentaInicial = new Cuenta(idCuenta, nombreBanco, numeroCuenta, tipo);
                builder.agregarCuentaInicial(cuentaInicial);
            }

            // 4. Crear notificación de bienvenida
            Notificacion bienvenida = new Notificacion(
                    UUID.randomUUID().toString(),
                    "¡Bienvenido a tu Billetera Virtual! Tu cuenta ha sido creada exitosamente.",
                    new java.util.Date(),
                    "BIENVENIDA"
            );
            builder.setNotificacionBienvenida(bienvenida);

            // 5. Construir y registrar usuario
            Usuario usuario = builder.build();
            BilleteraVirtual.getInstancia().getPerfiles().add(usuario);

            System.out.println("Usuario creado exitosamente con ID: " + idUsuario);
            return true;

        } catch (Exception e) {
            System.out.println("Error creando usuario: " + e.getMessage());
            return false;
        }
    }

    /**
     * Metodo que Genera un reporte completo de transacciones en formato especificado
     */
    public String generarReporteCompleto(String formato, String emailUsuario) {
        try {
            Usuario usuario = buscarUsuarioPorEmail(emailUsuario);
            if (usuario == null) {
                return "Usuario no encontrado";
            }

            // Obtener todas las transacciones del usuario
            List<Transaccion> transacciones = (List<Transaccion>) usuario.mostrarTodosLosMovimientos();

            // Usar patrón Adapter para generar el reporte
            ReporteExportable generador;
            if ("PDF".equalsIgnoreCase(formato)) {
                generador = new ReportePDF();
            }  else {
                return "Formato no soportado";
            }

            return generador.generarReporte(transacciones);

        } catch (Exception e) {
            return "Error generando reporte: " + e.getMessage();
        }
    }



    /**
     * Metodo que genera y asigna una notificacion de transferencia al usuario
     * @param usuario
     * @param monto
     * @param cuentaDestino
     */
    private void generarNotificacionTransferencia(Usuario usuario, double monto, String cuentaDestino) {
        Notificacion notif = new Notificacion(
                UUID.randomUUID().toString(),
                "Transferencia de $" + monto + " realizada a cuenta " + cuentaDestino,
                new java.util.Date(),
                "TRANSFERENCIA"
        );
        usuario.setNotificacion(notif);
    }

    /**
     * Metodo que genera un numero aleatoria de cuenta
     * @return
     */
    private String generarNumeroCuenta() {
        return String.format("%04d %04d %04d %04d",
                (int)(Math.random() * 10000),
                (int)(Math.random() * 10000),
                (int)(Math.random() * 10000),
                (int)(Math.random() * 10000));
    }


    /**
     * Metodo que busca un usuario registradi en la billetera por su correo electronico
     * @param email
     * @return
     */
    private Usuario buscarUsuarioPorEmail(String email) {
        for (Persona persona : BilleteraVirtual.getInstancia().getPerfiles()) {
            if (persona instanceof Usuario usuario && usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }
}
