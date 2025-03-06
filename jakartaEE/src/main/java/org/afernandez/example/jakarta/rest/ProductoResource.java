package org.afernandez.example.jakarta.rest;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.afernandez.example.jakarta.entity.Producto;
import org.afernandez.example.jakarta.service.ProductoService;

/**
 * Recurso REST para exponer los productos.
 */
@RequestScoped
@Path("/productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoResource {

    @Inject
    private ProductoService productoService;

    // Constructor sin argumentos requerido por CDI
    public ProductoResource() {}

    public ProductoResource(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Obtiene todos los productos.
     * @return lista de productos
     */
    @GET
    public List<Producto> obtenerTodos() {
        return this.productoService.obtenerTodos();
    }

    /**
     * Crea o actualiza un producto.
     * @param producto producto a crear o actualizar
     * @return respuesta con el producto guardado
     */
    @POST
    public Response guardar(Producto producto) {
        this.productoService.guardar(producto);
        return Response.status(Response.Status.CREATED).entity(producto).build();
    }

    /**
     * Elimina un producto por su ID.
     * @param id ID del producto
     * @return respuesta de eliminación
     */
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        this.productoService.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
