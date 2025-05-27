
package co.edu.uniquindio.poo.proyecto_final_pgii.model.gestores;

import co.edu.uniquindio.poo.proyecto_final_pgii.model.*;

import java.util.Collection;
import java.util.List;

public class GestorPresupuestos {
    private static GestorPresupuestos instancia;

    private GestorPresupuestos() {
    }

    public static GestorPresupuestos getInstancia() {
        if (instancia == null) {
            instancia = new GestorPresupuestos();
        }
        return instancia;
    }

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

    public Collection<Presupuesto> obtenerPresupuestosUsuario() {
        Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();
        if (usuarioActual == null) {
            throw new IllegalStateException("No hay usuario actual");
        }
        return usuarioActual.getListaPresupuestos();
    }

    public void eliminarPresupuesto(Presupuesto presupuesto) {
        Usuario usuarioActual = GestorSesion.getInstancia().getUsuarioActual();
        if (usuarioActual == null) {
            throw new IllegalStateException("No hay usuario actual");
        }
        usuarioActual.getListaPresupuestos().remove(presupuesto);
    }

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