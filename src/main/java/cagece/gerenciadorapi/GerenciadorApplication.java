package cagece.gerenciadorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class GerenciadorApplication {

	public static void main(String[] args) {

		System.out.println("Versão Spring: " + SpringVersion.getVersion());
		SpringApplication.run(GerenciadorApplication.class, args);
	}

}
