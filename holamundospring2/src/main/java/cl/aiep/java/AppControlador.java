package cl.aiep.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//notacion
public class AppControlador {
	@GetMapping("/saludo")//esto va en el http://localhost:8081/saludo
	public String saludar(Model modelo) {//objeto
		modelo.addAttribute("nombre", "Paola");
		return "saludo-view";//con este nombre se crea el archivo.html para haces la vista
	}
	@GetMapping("/saludo2")//html 5
	public String saludar2(Model modelo) {
	modelo.addAttribute("nombre", "Juanito");
	return "saludo-view2";
	}
	@GetMapping("/saludo3")
	public String saludar3(@RequestParam(name = "nombre", defaultValue = "Mundo") String nombre, Model modelo) {
	modelo.addAttribute("nombre", nombre);
	return "saludo-view";
	}
}
