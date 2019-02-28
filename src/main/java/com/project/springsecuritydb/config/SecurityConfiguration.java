package com.project.springsecuritydb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;



@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
      

	
	@Autowired
	private CustomUserDetailsService userDetailService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		System.out.println();
		http.csrf().disable();
		http.authorizeRequests()
		    .antMatchers("/**secured/**").authenticated()
		    .anyRequest().permitAll()
		    .and()
		    .formLogin().permitAll();
		
	}
	
	
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		
		
		auth.userDetailsService(userDetailService)
		    .passwordEncoder(new PasswordEncoder() {
				
				@Override
				public boolean matches(CharSequence rawPassword, String encodedPassword) {
					
					
					
					if(rawPassword.toString().equals(encodedPassword))
					{
						return true;
					}
					else
					return false;
				}
				
				@Override
				public String encode(CharSequence rawPassword) {
					// TODO Auto-generated method stub
					
					System.out.println("encode method"+rawPassword);
					
					return rawPassword.toString();
				}
			}) ;
		
	}
	
	
	

}
