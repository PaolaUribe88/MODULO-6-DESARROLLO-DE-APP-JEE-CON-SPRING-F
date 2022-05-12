package cl.aiep.java;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CftController {
	@GetMapping ("/")//AL NO TENER UN ASIGNADO SE ABRE DESDE EL NAVEGADOR DIRECTAMENTE EN EL LOCALHOST
	public String index() {
		
		return "index";//NOMBRE DE LA PLANTILLA DE Thymeleaf(sin html)
	}
	@GetMapping("/alumno")
	public String alumnoForm(Alumno alumno) {
		return "alumno-form";
	}
	@PostMapping ("/alumno")//metodo post
	public String alumnoProcesar(@Valid Alumno alumno, BindingResult informeValidacion) {
		//ALUMNO OBJETO A VALIDAR, CON UN OBJETO INFORMEVALIDACION
		if(informeValidacion.hasErrors()) {//SI HAY ERRORES VUELVE AL FORMULARIO DEL ALUMNO
			return "alumno-form";
		}
		return "alumno-ficha"; // SI NO HAY ERROR MUESTRO LA FICHA DEL ALUMNO SI PASA LA VALIDACION
	}
}
