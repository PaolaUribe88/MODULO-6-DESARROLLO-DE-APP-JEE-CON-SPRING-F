package cl.aiep.java.cft.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.aiep.java.cft.modelo.Carrera;
import cl.aiep.java.cft.repository.CarreraRepository;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	@Autowired
	CarreraRepository carreraRepository;
	
	@GetMapping("nuevo")
	public String carreraNueva(Carrera carrera) {
		return "carrera/form";
	}
	//EDITAR CARRERA
	@GetMapping("/editar/{carreraId}")
	public String carreraEditar(@PathVariable int carreraId, Model modelo) {
		Carrera carrera = carreraRepository.findById(carreraId);
		modelo.addAttribute("carrera", carrera);
		return "carrera/form"; 
	}
	//ELIMINAR CARRERA
	@GetMapping("/eliminar")
	public String eliminarCarrera(@RequestParam(name="id", required = true)int id) {
		carreraRepository.delete(id);
		return "redirect:/carrera/listado";
	}
	@GetMapping("/listado")
	public String listar(Model modelo) {
		List<Carrera> carreras = carreraRepository.findAll();
		modelo.addAttribute("carreras", carreras);
		return "carrera/listado";
	}
	@PostMapping ("/procesar")//metodo post, ALUMNO ES EL NOMBRE A VISUALIZAR EN HTML
	public String carreraProcesar(@Valid Carrera carrera, BindingResult informeValidacion) {
									//ALUMNO OBJETO A VALIDAR, CON UN OBJETO INFORMEVALIDACION
		if(informeValidacion.hasErrors()) {//SI HAY ERRORES VUELVE AL FORMULARIO DEL ALUMNO
			return "carrera/form";
		}
		if(carrera.getId()==0){
			carreraRepository.create(carrera);
		}else {
			carreraRepository.edit(carrera);
		}
		return "redirect:/carrera/listado"; // REDIRECCION EN CONTROLLER
	}
}

