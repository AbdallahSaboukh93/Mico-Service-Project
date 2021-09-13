package com.restfullProject.restfullProject.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.restfullProject.restfullProject.service.UserService;

@EnableWebSecurity
public class WebSecuirty extends WebSecurityConfigurerAdapter {
	private final UserService userService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecuirty(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,SecurityConstants.SIGN_UP_URL)
		.permitAll().anyRequest()
				.authenticated().and().addFilter(getAuthonticationFilter())
				.addFilter(new AuthorizationFilter(authenticationManager()))
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}

	
	public AuthonticationFilter getAuthonticationFilter()  throws Exception{
	final	AuthonticationFilter authonticationFilter=	new AuthonticationFilter(authenticationManager() ) ;
				authonticationFilter.setFilterProcessesUrl("/users/login");
		return authonticationFilter;
	}
}
