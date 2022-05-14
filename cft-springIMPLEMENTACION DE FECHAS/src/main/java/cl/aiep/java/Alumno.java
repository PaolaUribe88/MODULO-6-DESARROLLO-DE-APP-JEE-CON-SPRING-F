package cl.aiep.java;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Alumno {
	
	@Min(0)
	private int id;
	
	@Size (min = 3, max=20, message ="El NOMBRE  debe ir entre 3 y 20 caracteres")
	//nombre minimo 3 letras y maximo 20
	private String nombre;

	//edad minima 18, con message se puede personalizar el mensaje de rror
	private LocalDate fechaNacimiento;
		
	
	//CONSTRUCTOR VACIO
	public Alumno() {
		super();
	}
	//CONSRUCTOR COMPLETO
	public Alumno( int id, String nombre, LocalDate fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	//CONSRUCTOR sin id
	public Alumno(String nombre, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
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
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	

}
