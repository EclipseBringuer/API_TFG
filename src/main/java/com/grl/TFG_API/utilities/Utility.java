package com.grl.TFG_API.utilities;

import java.io.IOException;

/**
 * Clase de utilidad que proporciona métodos para operaciones comunes.
 */
public class Utility {
    /**
     * Abre la documentación en un navegador web.
     * <p>
     * Actualmente este método no es usado ya que al subirlo el railway
     * provoca una excepción en el despliegue por la configuración de los servidores.
     * Sin embargo en local se puede llamar y funciona perfectamente, desplegando swagger.
     * </p>
     */
    public static void openDocumentation() {
        try {
            new ProcessBuilder("cmd", "/c", "start", "chrome", "http://localhost:8080/docu")
                    .start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}