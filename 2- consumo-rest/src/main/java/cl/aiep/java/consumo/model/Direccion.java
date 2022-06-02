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
@JsonIgnoreProperties (ignoreUnknown = true)
public class Direccion {

	@JsonProperty("street")
	private String calle;
	@JsonProperty("suite")
	private String departamento;
	@JsonProperty("city")
	private String ciudad;
	@JsonProperty("zipcode")
	private String codigoZip;
}
