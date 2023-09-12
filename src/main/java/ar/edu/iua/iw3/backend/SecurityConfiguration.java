package ar.edu.iua.iw3.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//CORS: https://developer.mozilla.org/es/docs/Web/HTTP/CORS
		//CSRF: https://developer.mozilla.org/es/docs/Glossary/CSRF
		http.cors().and().csrf().disable()
			.authorizeHttpRequests().antMatchers("/**")
			.permitAll().anyRequest().authenticated();
		return http.build();
	}
}
