package cl.aiep.java.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.java.catalogo.exceptions.ProductoNoEncontradoException;
import cl.aiep.java.catalogo.model.Producto;
import cl.aiep.java.catalogo.repository.ProductoRepository;

@RestController// FACILITA LA TAREA DE CONVERTIR JAVA NORMAL EN FORMATO JSON (CONVIERTE X DEFECTO A UN ARCHIVO JSON)
@CrossOrigin(origins="*")//aqui estamos autorizando el consumo de webservice
public class ProductoController {
	
	@Autowired 
	private ProductoRepository productoRepository;

	@GetMapping("/productos")
	public List<Producto> todosLosProductos(){
		List<Producto> productos = productoRepository.findAll();
		return productos;
	}
	@PostMapping("/productos")
	public Producto nuevoProducto(@RequestBody Producto productoNuevo) {
		return productoRepository.save(productoNuevo);
	}
	@GetMapping("/productos/{id}")
	public Producto productoPorid(@PathVariable Long id) {
		return productoRepository.findById(id).orElseThrow(()->new ProductoNoEncontradoException(id));
	}
	@PutMapping("/productos/{id}")
	public Producto reemplazarProducto(@RequestBody Producto productoAReemplazar, @PathVariable Long id) {
		return productoRepository.findById(id)
				.map(producto->{
					producto.setNombre(productoAReemplazar.getNombre());
					producto.setPrecio(productoAReemplazar.getPrecio());
					return productoRepository.save(producto);
				})
				.orElseGet(()->{
					productoAReemplazar.setId(id);
					return productoRepository.save(productoAReemplazar);
				})
				;
	}
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable Long id) {
		productoRepository.deleteById(id);
	}
}
