package cl.aiep.java;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.aiep.java.cft.repository.AlumnoRepository;

@Controller
public class CftController {
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@PostMapping ("/alumno")//metodo post, ALUMNO ES EL NOMBRE A VISUALIZAR EN HTML
	public String alumnoProcesar(@Valid Alumno alumno, BindingResult informeValidacion) {
									//ALUMNO OBJETO A VALIDAR, CON UN OBJETO INFORMEVALIDACION
		if(informeValidacion.hasErrors()) {//SI HAY ERRORES VUELVE AL FORMULARIO DEL ALUMNO
			return "alumno-form";
		}
		if(alumno.getId()==0){
			alumnoRepository.create(alumno);
		}else {
			alumnoRepository.edite(alumno);
		}
		return "alumno-ficha"; // SI NO HAY ERROR MUESTRO LA FICHA DEL ALUMNO SI PASA LA VALIDACION
	}
	
	@GetMapping ("/")//http://localhost:8081/ AL NO TENER UN ASIGNADO SE ABRE DESDE EL NAVEGADOR DIRECTAMENTE EN EL LOCALHOST
	public String index() {
		
		return "index";//NOMBRE DE LA PLANTILLA DE Thymeleaf(sin html)
	}
	@GetMapping("/alumno")//http://localhost:8081/alumno
	public String alumnoForm(Alumno alumno) {
		return "alumno-form";
	}
	
	//ELIMINAR ALUMNO
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam(name="id", required = true) int id) {
		return "index";
}
	//EDITAR ALUMNO
	@GetMapping("/editar")
	public String editar(@RequestParam(name="id", required = true)int id) {
		return "index";
	}
}
