package cl.aiep.java.consumo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties (ignoreUnknown = true)//ESTAMOS DICIENDO QUE LAS PROPIEDADES QUE NO CALCEN CON EL DESTINO, LAS IGNORE
public class Usuario {

	private Long id;
	@JsonProperty("name")
	//ESTAMOS DICIENDO QUE ESTE ATRIBUTO QUE VIENE POR DEFECTO DE LA API, NOSOTROS QUEREMOS NOMBRARLA EN ESPAÑOL
	private String nombre;
	private String username;
	private String email;
	private String phone;
	private String website;
	@JsonProperty("address")
	private Direccion direccion;
	
	
}
