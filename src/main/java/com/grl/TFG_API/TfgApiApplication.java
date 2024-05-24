package com.grl.TFG_API;

//import com.grl.TFG_API.utilities.Utility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia la aplicación Spring Boot y abre la documentación en un navegador web.
 */
@SpringBootApplication
public class TfgApiApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     * <p>
     * Este método ejecuta la aplicación utilizando SpringApplication.run y puede abrir la documentación en un navegador web si se descomenta la línea correspondiente.
     * </p>
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(TfgApiApplication.class, args);
        //Utility.openDocumentation();
    }
}