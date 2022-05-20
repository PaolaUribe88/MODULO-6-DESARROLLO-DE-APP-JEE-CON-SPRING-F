package cl.aiep.java.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class SitioController {
	
	@GetMapping("/inicio")
	public String inicio() {//PUEDE SER INDEX TAMBIEN
		return "inicio";
	}
	
	@GetMapping("/nosotros")
	public String nosotros() {
		return "nosotros";
	}
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
}
