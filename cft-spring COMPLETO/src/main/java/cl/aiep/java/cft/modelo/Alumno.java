package cl.aiep.java.cft.modelo;

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
	private Carrera carrera;
		
	
	//CONSTRUCTOR VACIO
	public Alumno() {
		super();
	}
	

	//CONSRUCTOR 
	
	public Alumno(int id,String nombre,LocalDate fechaNacimiento, Carrera carrera) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.carrera = carrera;
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
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
}
