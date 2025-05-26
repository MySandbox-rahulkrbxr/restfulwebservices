package com.rahul.resetfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//		1. All request should be authenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//		2. If a request is not authenticated, a web page is shown 
		// search Customizer interface and add static withDefaults() location (qualifier name)
		http.httpBasic(withDefaults());
//		3. CSRF -> POST, PUT
//		http.csrf().disable(); // Deprecated in SB 3.1.x
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
}
