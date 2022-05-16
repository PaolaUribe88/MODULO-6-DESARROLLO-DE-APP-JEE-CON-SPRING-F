package cl.aiep.java;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
	
	@GetMapping ("/")//http://localhost:8081/ AL NO TENER UN ASIGNADO SE ABRE DESDE EL NAVEGADOR DIRECTAMENTE EN EL LOCALHOST
	public String index() {
		
		return "index";//NOMBRE DE LA PLANTILLA DE Thymeleaf(sin html)
	}
}
