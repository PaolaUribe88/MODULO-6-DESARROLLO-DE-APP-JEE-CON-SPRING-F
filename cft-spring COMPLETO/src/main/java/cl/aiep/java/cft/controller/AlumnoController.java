package cl.aiep.java.cft.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.aiep.java.cft.modelo.Alumno;
import cl.aiep.java.cft.modelo.Carrera;
import cl.aiep.java.cft.repository.AlumnoRepository;
import cl.aiep.java.cft.repository.CarreraRepository;

@Controller
@RequestMapping("/alumno")//PREFIJO DE LAS RUTAS
public class AlumnoController {
	@Autowired
	AlumnoRepository alumnoRepository;
	@Autowired
	CarreraRepository carreraRepository;
	
	@GetMapping("/nuevo")//http://localhost:8081/alumno/nuevo
	public String alumnoNuevo(Alumno alumno, Model modelo) {
		List<Carrera> carreras = carreraRepository.findAll();
		modelo.addAttribute("carreras", carreras);
		return "alumno/form";
	}
	//EDITAR ALUMNO
	@GetMapping("/editar/{alumnoId}") // http://localhost/alumno/editar/5
	public String alumnoEditar(@PathVariable int alumnoId, Model modelo) {
		Alumno alumno = alumnoRepository.findById(alumnoId);
		modelo.addAttribute("alumno", alumno);
		List<Carrera> carreras = carreraRepository.findAll();
		modelo.addAttribute("carreras", carreras);
		return "alumno/form";
	}
	//ELIMINAR ALUMNO
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam(name="id", required = true) int id) {
		alumnoRepository.delete(id);
			return "redirect:/alumno/listado";
	}	
	@GetMapping("/listado")
	public String listar(Model modelo) {
		List<Alumno> alumnos = alumnoRepository.findAll();
		modelo.addAttribute("alumnos", alumnos);
		return "alumno/listado";
	}
	@PostMapping ("/procesar")//metodo post, ALUMNO ES EL NOMBRE A VISUALIZAR EN HTML
	public String alumnoProcesar(@Valid Alumno alumno, BindingResult informeValidacion) {
									//ALUMNO OBJETO A VALIDAR, CON UN OBJETO INFORMEVALIDACION
		if(informeValidacion.hasErrors()) {//SI HAY ERRORES VUELVE AL FORMULARIO DEL ALUMNO
			return "alumno/form";
		}
		if(alumno.getId()==0){
			alumnoRepository.create(alumno);
		}else {
			alumnoRepository.edite(alumno);
		}
		return "redirect:/alumno/listado"; // REDIRECCION EN CONTROLLER
	}
	
	
	

	
}
