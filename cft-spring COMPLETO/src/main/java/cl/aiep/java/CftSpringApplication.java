package cl.aiep.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cl.aiep.java.cft.modelo.Carrera;
import cl.aiep.java.cft.repository.CarreraRepository;

@SpringBootApplication
public class CftSpringApplication implements WebMvcConfigurer{

	@Autowired
	private CarreraRepository carreraRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CftSpringApplication.class, args);
	}


	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new Converter<String, Carrera>() {
			@Override
			public Carrera convert(String strFormularioCarreraId) {
				int id = Integer.parseInt(strFormularioCarreraId);
				Carrera carrera = carreraRepository.findById(id);
				return carrera;
			}
		});
	}
	
	

}
