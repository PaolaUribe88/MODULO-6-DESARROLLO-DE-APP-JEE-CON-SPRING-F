package cl.aiep.java.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class UsuariosAutenticacion {
	
	@Bean
	//ESTE METODO VA A PRODUCIR UNA INSTANCIA QUE VA SER INYECTABLE EN ESTE CONTENEDOR DE SPRING
	public UserDetailsService usuarios() {
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		UserDetails usuario1 = userBuilder
		.username("Admin")
		.password("1234")
		.roles("admin")
		.build();
		
		UserDetails usuario2 = userBuilder
		.username("Pilar")
		.password("1234")
		.roles("user")
		.build();
		
		UserDetails usuario3 = userBuilder
		.username("Jessie")
		.password("1308")
		.roles("admin")
		.build();
		
		return new InMemoryUserDetailsManager(usuario1,usuario2,usuario3);
	}
}
