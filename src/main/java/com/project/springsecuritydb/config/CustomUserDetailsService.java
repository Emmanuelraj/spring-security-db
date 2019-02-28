package com.project.springsecuritydb.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.springsecuritydb.interfaces.UserRepository;
import com.project.springsecuritydb.model.CustomUserDetails;
import com.project.springsecuritydb.model.User;



@Service
public class CustomUserDetailsService implements UserDetailsService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
    Optional<User>  optionalUser	=	userRepository.findByUsername(username);
    
    
    
       if(optionalUser.isPresent())
       {
    	   System.out.println("username exists in db");
    	   
    	   return new CustomUserDetails(optionalUser.get());
       }
		
       else
       {
    	   throw new  UsernameNotFoundException("username not found in db"); 
       }
		
	}

}
