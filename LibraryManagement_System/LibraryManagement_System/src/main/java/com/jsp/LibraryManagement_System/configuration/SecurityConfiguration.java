package com.jsp.LibraryManagement_System.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService getDetailsService() {
		return new UserInfoUserDetailsService();
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(getPasswordEncoder());
		provider.setUserDetailsService(getDetailsService());
		return provider;
	}
	
	@Bean
	public SecurityFilterChain getFilterChain(HttpSecurity security) throws Exception {
		security.csrf((csrf) -> csrf.disable());
		security.cors(Customizer.withDefaults());
		security.
		authorizeHttpRequests(authorization ->
		authorization.requestMatchers("/api/v1/librarians").hasRole("ADMIN")
					 .requestMatchers("/api/v1/librarians").hasRole("ADMIN")
					 .requestMatchers("/api/v1/librarians/{id}").hasRole("ADMIN")
					 .requestMatchers("/api/v1/librarians/{id}").hasRole("ADMIN")
					 .requestMatchers("/api/v1/books").hasRole("LIBRARIAN")
					 .requestMatchers("/api/v1/authors").hasRole("LIBRARIAN")
					 .requestMatchers("/api/v1/authors/byname/{name}").hasRole("LIBRARIAN")
					 .requestMatchers("/api/v1/authors/sort").hasRole("LIBRARIAN")
					 .requestMatchers("/api/v1/authors/{id}").hasRole("LIBRARIAN")
					 .requestMatchers("/api/v1/authors/{id}").hasRole("LIBRARIAN")
					 .requestMatchers("/api/v1/students").hasRole("STUDENT")
					 .anyRequest()
					 .authenticated())
		.httpBasic(Customizer.withDefaults());
		return security.build();
	}

}







