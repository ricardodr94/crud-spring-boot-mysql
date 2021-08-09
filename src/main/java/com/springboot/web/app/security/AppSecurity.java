package com.springboot.web.app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {
	
	//Metodo de autenticacion
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("ricardo")
		        .password("{noop}123") 
				.roles("ADMIN", "USER")
			.and()
			    .withUser("andres").
			    password("{noop}123").
			    roles("USER");
	}

}
