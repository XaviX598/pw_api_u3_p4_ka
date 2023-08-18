package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

//clase que nos permite validar un token
@Component
public class JwtUtils {

	@Value("${app.jwt.secret}")
	private String jwtSecret;

	private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

	// creamos un metodo para validar el token
	public boolean validateJwtToken(String token) {
		Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		return true;
	}

}
