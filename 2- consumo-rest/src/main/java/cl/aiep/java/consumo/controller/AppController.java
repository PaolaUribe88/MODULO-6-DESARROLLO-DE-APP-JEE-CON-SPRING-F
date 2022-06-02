package cl.aiep.java.consumo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import cl.aiep.java.consumo.model.Usuario;

@Controller
public class AppController {

	@GetMapping("/")
	public String usuarios(RestTemplate restTemplate, Model modelo) {
		String url="https://jsonplaceholder.typicode.com/users";
		Usuario[] usuarios = restTemplate.getForObject(url, Usuario[].class);
		modelo.addAttribute("usuarios",usuarios);
		return "usuarios";
	}
}
