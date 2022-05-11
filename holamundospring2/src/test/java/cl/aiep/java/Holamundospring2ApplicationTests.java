package cl.aiep.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Holamundospring2ApplicationTests {
	
	@Autowired
	//la anotacion autowid inyecta la dependecia en appControlador
	//va asegurar que spring va a instanciar
	private AppControlador appControlador;
	// variable de instancia, atributo o propiedad

	@Test
	void contextLoads() {
		assertThat(appControlador).isNotNull();
		// se esta revisando que el objeto appControlador no sea nulo
		
	}

}
