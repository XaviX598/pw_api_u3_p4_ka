package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

//clase que nos permite validar un token
@Component
public class JwtUtils {

	@Value("${app.jwt.secret}")
	private String jwtSecret;

	private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

	// creamos un metodo para validar el token
	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		}catch(ExpiredJwtException e){
			LOG.error("Token expirado{}",e.getMessage());
		}catch(SignatureException e){
			LOG.error("Token invalido{}",token);
		}
		
		return false;
	}
	
	public String getUsernameFromJwtToken(String token) {//tenemos el nombre a aprtir del token 
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

}
