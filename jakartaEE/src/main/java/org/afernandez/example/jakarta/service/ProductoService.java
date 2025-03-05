package org.afernandez.example.jakarta.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.afernandez.example.jakarta.entity.Producto;

@Stateless
public class ProductoService {

    @PersistenceContext(unitName = "miUnidadPersistencia")
    private EntityManager entityManager;

    /**
     * Obtiene todos los productos.
     * @return lista de productos
     */
    public List<Producto> obtenerTodos() {
        List<Producto> productos = entityManager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();

        // Si no hay productos en la BD, añadimos algunos por defecto
        if (productos.isEmpty()) {
            productos = List.of(
                    new Producto("Laptop", 1200.99),
                    new Producto("Mouse", 25.50),
                    new Producto("Teclado", 45.75),
                    new Producto("Monitor", 199.99)
            );
        }

        return productos;
    }

    /**
     * Guarda un nuevo producto o actualiza uno existente.
     * @param producto producto a guardar o actualizar
     */
    public void guardar(Producto producto) {
        if (producto.getId() == null) {
            entityManager.persist(producto);
        } else {
            entityManager.merge(producto);
        }
    }

    /**
     * Elimina un producto por su ID.
     * @param id ID del producto
     */
    public void eliminar(Long id) {
        Producto producto = entityManager.find(Producto.class, id);
        if (producto != null) {
            entityManager.remove(producto);
        }
    }
}
