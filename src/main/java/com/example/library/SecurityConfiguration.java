package com.example.library;

import com.example.library.security.CustomAuthenticationProvider;
import com.example.library.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	private final CustomAuthenticationProvider authenticationProvider;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.cors().and()
				.authorizeHttpRequests(authorize -> {
							authorize.requestMatchers("/user", "/user/").permitAll();
							authorize.requestMatchers(HttpMethod.POST, "/book", "/book/", "/borrow/**").hasAuthority(Roles.ADMIN.toString());
							authorize.anyRequest().authenticated();
						}
				)
				.httpBasic(Customizer.withDefaults())
				.build();
	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(authenticationProvider);
		return authenticationManagerBuilder.build();
	}
}
