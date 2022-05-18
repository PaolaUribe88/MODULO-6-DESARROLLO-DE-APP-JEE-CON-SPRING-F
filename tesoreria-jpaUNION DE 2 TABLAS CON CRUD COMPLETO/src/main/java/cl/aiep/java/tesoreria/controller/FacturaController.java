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

import cl.aiep.java.tesoreria.modelo.Factura;
import cl.aiep.java.tesoreria.modelo.Proveedor;
import cl.aiep.java.tesoreria.repository.FacturaRepository;
import cl.aiep.java.tesoreria.repository.ProveedorRepository;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	ProveedorRepository proveedorRepository;
	
		@GetMapping("/index")//http://localhost:8081/ AL NO TENER UN ASIGNADO SE ABRE DESDE EL NAVEGADOR DIRECTAMENTE EN EL LOCALHOST
		public String index() {
	
			return "index";
		
	}
		@GetMapping ("/nuevo") 
		public String nuevo(Factura factura, Model modelo){
			List<Proveedor> proveedores = proveedorRepository.findAll();
			modelo.addAttribute("proveedores",proveedores);
			return "/factura/form";
	}
		@PostMapping("/procesar")
		private String procesar(@Valid Factura factura, BindingResult informeValidacion) {
			if(informeValidacion.hasErrors()) return"factura/form";
		
			facturaRepository.saveAndFlush( factura ); // línea nueva
			return "redirect:/factura/listado";
	}
		@GetMapping("/listado")
		private String listado(Model modelo ) {
			List<Factura> facturas = facturaRepository.findAll();
			modelo.addAttribute("facturas",facturas);
			return "factura/listado";
		
	}
		//EDITAR FACTURA
		@GetMapping("/editar/{id}") // http://localhost/alumno/editar/5
		public String facturaEditar(@PathVariable(name = "id")Factura factura, Model modelo) {
			List<Proveedor>proveedores = proveedorRepository.findAll();
			modelo.addAttribute("proveedores",proveedores);
			modelo.addAttribute("factura", factura);
			return "factura/form";
		}
		//ELIMINAR FACTURA
		@GetMapping("/eliminar/{id}")
			public String eliminar(@PathVariable Long id) {
			facturaRepository.deleteById(id);
			return "redirect:/factura/listado";
		}
}