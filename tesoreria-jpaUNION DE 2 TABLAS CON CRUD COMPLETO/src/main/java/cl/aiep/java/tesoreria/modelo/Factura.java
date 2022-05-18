package cl.aiep.java.tesoreria.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table (uniqueConstraints = {@UniqueConstraint(columnNames = { "proveedor_id","folio" })})//LLAVE UNICA COMPUESTA
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	@ManyToOne //IMPLEMENTACION DE 1 A MUCHOS PARA UNIR CON ONE PROVEEDOR OSEA 1, SI FUERAN MAS SERIA MANYTOANY DE MUCHOS A MUCHOS
	private Proveedor proveedor;
	private LocalDate fecha;
	private Long folio;
	private double monto;
	
	//CONSTRUCTOR VACIO
	public Factura() {
		super();
	}
	//CONSTRUCTOR COMPLETO
	public Factura(Long id, Proveedor proveedor, LocalDate fecha, Long folio, double monto) {
		super();
		this.id = id;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.folio = folio;
		this.monto = monto;
	}
	//GETTER Y SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Long getFolio() {
		return folio;
	}
	public void setFolio(Long folio) {
		this.folio = folio;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	
	
}
