package cl.aiep.java.tesoreria.controller;

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

import cl.aiep.java.tesoreria.modelo.Proveedor;
import cl.aiep.java.tesoreria.repository.ProveedorRepository;

@Controller
@RequestMapping ("/proveedor")
public class ProveedorController {
	@Autowired
	ProveedorRepository proveedorRepository;
	@GetMapping ("/nuevo") 
	public String nuevo(Proveedor proveedor){
		return "/proveedor/form";
	}
	
	@PostMapping("/procesar")
	private String procesar(@Valid Proveedor proveedor, BindingResult informeValidacion) {
		if(informeValidacion.hasErrors()) return"proveedor/form";
		proveedorRepository.saveAndFlush( proveedor ); // línea nueva
		return "redirect:/proveedor/listado";
	}
	@GetMapping("/listado")
	private String listado(Model modelo ) {
		List<Proveedor> proveedores = proveedorRepository.findAll();
		modelo.addAttribute("proveedores",proveedores);
		return "proveedor/listado";
		
	}
		//EDITAR PROVEEDOR
		@GetMapping("/editar/{id}") // http://localhost/alumno/editar/5
		public String proveedorEditar(@PathVariable(name = "id")Proveedor proveedor, Model modelo) {
			modelo.addAttribute("proveedor", proveedor);
			return "proveedor/form";
		}
		//ELIMINAR PROVEEDOR
		@GetMapping("/eliminar/{id}")
		public String eliminar(@PathVariable Long id) {
			proveedorRepository.deleteById(id);
				return "redirect:/proveedor/listado";
		}
}
