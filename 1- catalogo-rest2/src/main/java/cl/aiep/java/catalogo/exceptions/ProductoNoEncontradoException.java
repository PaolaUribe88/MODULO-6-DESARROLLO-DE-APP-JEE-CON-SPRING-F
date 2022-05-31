package cl.aiep.java.catalogo.exceptions;

import org.jboss.jandex.ClassExtendsTypeTarget;

public class ProductoNoEncontradoException extends RuntimeException{
	
	public ProductoNoEncontradoException (Long id) {
		super(String.format("Producto con id %s no encontrado", id));
	}
}
	
