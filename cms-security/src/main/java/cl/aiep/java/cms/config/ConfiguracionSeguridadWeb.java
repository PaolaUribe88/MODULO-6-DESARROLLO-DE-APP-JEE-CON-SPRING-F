package cl.aiep.java.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridadWeb extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//VAMOS A CONFIGURAR LAS RUTAS A NECESITAR
		http
			.authorizeRequests(authorize -> authorize
					.mvcMatchers("/", "/nosotros", "/contacto").permitAll()
					.mvcMatchers("/admin/index", "/admin/reporte").hasRole("ADMIN")
					.anyRequest().authenticated())
			.logout(logout -> logout
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
					);
	}

}
