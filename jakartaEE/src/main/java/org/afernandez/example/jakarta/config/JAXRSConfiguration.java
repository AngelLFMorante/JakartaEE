package org.afernandez.example.jakarta.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Configuración de JAX-RS para la aplicación.
 */
@ApplicationPath("/api")
public class JAXRSConfiguration extends Application {
}
