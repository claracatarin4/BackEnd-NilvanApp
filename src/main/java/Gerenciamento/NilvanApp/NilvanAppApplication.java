package Gerenciamento.NilvanApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "API Example", version = "v1", description = "Descrição da API"))
@SpringBootApplication
public class NilvanAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NilvanAppApplication.class, args);
	}

}
