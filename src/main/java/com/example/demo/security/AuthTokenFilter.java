package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter { // OncePerRequestFilter este es un filtro para validar el
															// token

	private static final Logger LOG = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Autowired
	private JwtUtils jwtUtils;

	// el token viene en el header, la key debe ser authorized o Authorization y el
	// valor del token debe venir con el nombre Bearer luego espacio y luego el
	// token
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// el friltro se debe ejecutar antes de que se consuma el api, los filtros se
		// contruyen para ejecutar antes que se consuma el metodo
		// en este caso se valida el token
		try {
			String jwt = this.parseJwt(request);
			if (jwt != null && this.jwtUtils.validateJwtToken(jwt)) {
				// Como es valido el token le vamos a autenticar
				String nombre = this.jwtUtils.getUsernameFromJwtToken(jwt);

				// le autenticamos
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(nombre,
						null, new ArrayList<>()); // nombre del token, contrase;a y lista de errores
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication); // seteamos la autenticacion en la
																						// sesion
			}
		} catch (Exception e) {
			LOG.error("No se pudo realizar la autenticacion con el token enviado: {}", e.getMessage());
		}
		filterChain.doFilter(request, response);
	}

	//obtiene el token puro 
	private String parseJwt(HttpServletRequest request) {
		String valorCompleto = request.getHeader("Authorization");
		if (StringUtils.hasText(valorCompleto) && valorCompleto.startsWith("Bearer ")) {
			return valorCompleto.substring(7, valorCompleto.length()); // aqui se saca el token a partir de la posicion
																		// 7 debido a Bearer y espacio
		}
		return null;
	}

}
