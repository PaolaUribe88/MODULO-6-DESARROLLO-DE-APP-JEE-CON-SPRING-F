package cl.aiep.java;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Alumno {
	@Min(0)
	private int id;
	
	@Size (min = 3, max=20, message ="El NOMBRE  debe ir entre 3 y 20 caracteres")
	//nombre minimo 3 letras y maximo 20
	private String nombre;
	@Min (value =18, message="Debe ser Mayor a 18 Años") 
	//edad minima 18, con message se puede personalizar el mensaje de rror
	private int edad;
		
	
	//CONSTRUCTOR VACIO
	public Alumno() {
		super();
	}
	//CONSRUCTOR COMPLETO
	public Alumno( int id, String nombre,int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}

	//CONSRUCTOR sin id
	public Alumno(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	//GETTER Y SETTER
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	

}
