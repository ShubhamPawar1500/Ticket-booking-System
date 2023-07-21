package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.Service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/ticket/register");
		web.ignoring().antMatchers("/ticket/saveuser");
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeHttpRequests().antMatchers("/resources/**").permitAll().anyRequest().authenticated()
//		.and().formLogin().loginPage("/ticket/login").usernameParameter("name").permitAll()
//		.and().logout().permitAll();
		http.csrf().disable().authorizeHttpRequests((authorize)->
		authorize.anyRequest().authenticated()
		).formLogin(
				form -> form
				        .loginPage("/ticket/login")
				        .loginProcessingUrl("/ticket/login")
				        .defaultSuccessUrl("/ticket/home").permitAll()
	    ).logout(
	    		logout -> logout
	    				  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	    				  .permitAll());
		
	}
	
	

	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
