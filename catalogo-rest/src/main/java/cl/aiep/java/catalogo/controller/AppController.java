package cl.aiep.java.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.java.catalogo.modelo.Producto;
import cl.aiep.java.catalogo.repository.ProductoRepository;


@RestController
@CrossOrigin(origins="*")//aqui estamos autorizando el consumo de webservice
public class AppController {
	
	@Autowired 
	ProductoRepository productoRepository;

	@GetMapping("/")//RUTAS
	public String instalar() {
		//CON EL COUNT LE INGRESAMOS UN  CONDICIONAL PARA QUE AL CARGAR NO REPITA LOS DATOS
		long count = productoRepository.count();
		if (count == 0) {
		Producto producto1 = new Producto(null,"Plato Greda",4990);
		Producto producto2 = new Producto(null,"Plato Ceramica",8990);
		Producto producto3 = new Producto(null, "Plato Vidrio",3990);
		
		productoRepository.saveAndFlush(producto1);
		//saveandflush le dice a la base de datos que guarde automaticamente los datos
		productoRepository.saveAndFlush(producto2);
		productoRepository.saveAndFlush(producto3);
		return "Base de datos Poblada";//devuelve informacion por consola
	
		}else {
			return "Ya se realizo la instalacion";
		}
	}
	@GetMapping("/productos/destacados")
	public List<Producto> productosDestacador(){
		List<Producto> productos = productoRepository.findAll();
		return productos;
	}
}
