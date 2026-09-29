package io.swagger.v3.rest.integration.servlet;

import jakarta.servlet.ServletContainerInitializer;
import org.testng.annotations.Test;

import java.util.ServiceLoader;

import static org.testng.Assert.assertTrue;

/** Verifies that the Jakarta Servlet SPI advertises the migrated initializer class. */
public class RestServletInitializerNamespaceTest {

    @Test
    public void servletInitializerIsDiscoverableUnderRestNamespace() {
        boolean found = ServiceLoader.load(ServletContainerInitializer.class).stream()
                .map(ServiceLoader.Provider::type)
                .anyMatch(type -> type.getName()
                        .equals("io.swagger.v3.rest.integration.servlet.SwaggerServletInitializer"));

        assertTrue(found, "Jakarta Servlet SPI must provide the REST namespace initializer");
    }
}
