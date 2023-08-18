package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurity {


	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	// metodo que permita hacer publica a la api de autenticacion
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.anyRequest().authenticated(); 
		
		http.addFilterBefore(this.authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class); //nosotros decimos que antes que se consuma el api va a ver un filtro que va a validar el token antes que se consuma el negociio
		
		return http.build();
	}
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		
		return new AuthTokenFilter();
		
	}

	

}
