package br.com.antonio.APICarros;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.antonio.APICarros.principal.Principal;

@SpringBootApplication
public class ApiCarrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiCarrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}