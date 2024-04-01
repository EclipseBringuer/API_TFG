package com.grl.TFG_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia la aplicación Spring Boot y abre la documentación en un navegador web.
 */
@SpringBootApplication
public class TfgApiApplication {

	/**
	 * Método principal que inicia la aplicación Spring Boot y abre la documentación en un navegador web.
	 * @param args Argumentos de línea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(TfgApiApplication.class, args);
	}
}