package com.example.demo.util;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Date;


@Component
public class JwtUtil {
	 private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generates a secure key
	 public String generateToken(String username){
	        return Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
	                .signWith(SECRET_KEY) // Use the generated key
	                .compact();
	    }

	    public String extractUsername(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(SECRET_KEY)
	                .build()
	                .parseClaimsJws(token)
	                .getBody()	
	                .getSubject();
	    }

	    public boolean validateToken(String token, String username) {
	        String extractedUsername = extractUsername(token);
	        return (username.equals(extractedUsername) && !isTokenExpired(token));
	    }

	    private boolean isTokenExpired(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(SECRET_KEY)
	                .build()
	                .parseClaimsJws(token)
	                .getBody()
	                .getExpiration()
	                .before(new Date());
	    }
	}
