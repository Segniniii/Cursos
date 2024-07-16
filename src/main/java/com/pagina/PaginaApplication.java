package com.pagina;

import com.pagina.config.UsuarioSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(UsuarioSecurity.class) 
public class PaginaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaginaApplication.class, args);
	}

}
