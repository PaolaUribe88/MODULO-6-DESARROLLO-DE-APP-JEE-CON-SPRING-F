package cl.aiep.java.cft.modelo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Carrera {
	@Min(0)
	int id; 
	@Size (min = 3, max=20, message ="El NOMBRE  debe ir entre 3 y 20 caracteres")
	private String nombre;
	
	private String descripcion;
	
	//CONSTRUCTOR VACIO
	public Carrera() {
		super();
	}

	//CONSTRUCTOR COMPLETO
	public Carrera(int id, String nombre,String descripcion) {
	
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
