package com.alura.conversor_de_monedas;

import com.alura.conversor_de_monedas.principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorDeMonedasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversorDeMonedasApplication.class, args);

		Principal app = new Principal();
			app.conversor();

		}
	}

