package com.myproject.votingapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	SecurityFilterChain securityfilter(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeHttpRequests().anyRequest().permitAll();
//			.requestMatchers("").authenticated()
//			.anyRequest().permitAll();
		http.formLogin()
		.and().logout().logoutSuccessUrl("/loginpage");
		return http.build();
	}

}
