package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeHttpRequests()
	            .requestMatchers("/user/hotels","/user/buses","/user/trains").permitAll() // Allow access to this endpoint
	            .anyRequest().authenticated(); // Secure other endpoints
	        return http.build();
	    }
}