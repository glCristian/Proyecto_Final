
package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;

import java.util.Collection;
import java.util.List;

/**
 * Clase singleton para gestionar la creacion, actualizacion, eliminacion
 * y consulta de presupuestos asociados el usuario actual de la sesion
 */
public class GestorPresupuestos {
    private static GestorPresupuestos instancia;

    /**
     * Constructor privado de la clase GestorPresupuesto
     */
    private GestorPresupuestos() {
    }


    /**
     * Metodo que retorna la instancia unica de gestorPresupuestos, creando una nueva si no existe
     * @return
     */
    public static GestorPresupuestos getInstancia() {
        if (instancia == null) {
            instancia = new GestorPresupuestos();
        }
        return instancia;
    }


    /**
     * Metodo para crear un nuevo presupuesto y lo añade a la lista de presupuestos del usuario actual
     * @param id
     * @param nombre
     * @param montoTotal
     * @param montoGastado
     * @param categoria
     */
    public void crearPresupuesto(String id, String nombre, double montoTotal,
                                 double montoGastado, Categoria categoria) {
        Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();

        if (usuarioActual == null) {
            throw new IllegalStateException("No hay usuario actual");
        }

        if (montoTotal <= 0 || montoGastado < 0 || montoGastado > montoTotal) {
            throw new IllegalArgumentException("Montos inválidos");
        }

        Presupuesto presupuesto = new Presupuesto(id, nombre, montoTotal, 0, categoria);
        presupuesto.setMontoGastado(montoGastado);
        usuarioActual.getListaPresupuestos().add(presupuesto);
    }


    /**
     * Metodo que obtiene las presupuestos asociados al usuario actual
     * @return
     */
    public Collection<Presupuesto> obtenerPresupuestosUsuario() {
        Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();
        if (usuarioActual == null) {
            throw new IllegalStateException("No hay usuario actual");
        }
        return usuarioActual.getListaPresupuestos();
    }


    /**
     * Metodo que elimina un presupuesto de la lista del usuario actual
     * @param presupuesto
     */
    public void eliminarPresupuesto(Presupuesto presupuesto) {
        Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();
        if (usuarioActual == null) {
            throw new IllegalStateException("No hay usuario actual");
        }
        usuarioActual.getListaPresupuestos().remove(presupuesto);
    }


    /**
     * Metodo que actualiza los datos de un presupuesto existente
     * @param presupuesto
     * @param nombre
     * @param montoTotal
     * @param montoGastado
     * @param categoria
     */
    public void actualizarPresupuesto(Presupuesto presupuesto, String nombre,
                                      double montoTotal, double montoGastado, Categoria categoria) {
        if (montoTotal <= 0 || montoGastado < 0 || montoGastado > montoTotal) {
            throw new IllegalArgumentException("Montos inválidos");
        }

        presupuesto.setNombre(nombre);
        presupuesto.setMontoAsignado(montoTotal);
        presupuesto.setMontoGastado(montoGastado);
        presupuesto.setCategoria(categoria);
    }


    /**
     * Metodo que busca un presupuesto por su ID en la lista del usuario actual
     * @param id
     * @return
     */
    public Presupuesto buscarPresupuestoPorId(String id) {
        Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();
        if (usuarioActual == null) {
            throw new IllegalStateException("No hay usuario actual");
        }
        for (Presupuesto presupuesto : usuarioActual.getListaPresupuestos()) {
            if (presupuesto.getIdPresupuesto().equals(id)) {
                return presupuesto;
            }
        }
        return null;
    }

}