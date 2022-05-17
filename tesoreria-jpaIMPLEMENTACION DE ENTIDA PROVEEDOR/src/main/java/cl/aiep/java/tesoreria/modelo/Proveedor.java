package cl.aiep.java.tesoreria.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //notacion para configurar que la base de datos se haga automaticamente
public class Proveedor {
	
	//SETEAR LLAVE PRIMARIA
	@Id // siempre la llave primaria va sobre el que decidimos que sea primaria
	@GeneratedValue(strategy = GenerationType.AUTO)//LE DICE A HIBERNATE QUE CREE UNA LLAVE AUTOINCREMENTAL
	private Long id;
	@Column (nullable = false, length = 10)//MODIFICAMOS O MEJORAMOS ALGUNAS PROPIEDADES
	private String rut;
	@Column(nullable = false)
	private String razonSocial;
	
	//CONSTRUCTOR EN BLANCO
	public Proveedor() {
		super();
	}
	//CONSTRUCTOR COMPLETO
	public Proveedor(Long id, String rut, String razonSocial) {
		super();
		this.id = id;
		this.rut = rut;
		this.razonSocial = razonSocial;
	}
	//GETTER Y SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
}
