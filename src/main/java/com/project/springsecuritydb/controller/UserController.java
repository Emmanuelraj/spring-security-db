package com.project.springsecuritydb.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.springsecuritydb.interfaces.UserRepository;
import com.project.springsecuritydb.model.Role;
import com.project.springsecuritydb.model.User;

@Controller
public class UserController 
{
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@GetMapping("/register")
	public String register(@ModelAttribute("user") User user,BindingResult bindingResult)
	{
		
		
		return "register";
	}
	
	
	
	@PostMapping("/registerForm")
	public String onSubmitAddUserRegister(@ModelAttribute("user") User user,BindingResult bindingResult)
	{
		System.out.println("onSubmit Add UserMethod"+user.getRole());
		
		
	      Role role = new Role();
	      
	      
	      System.out.println("before"+role.getRoleId());
	      
	      role.setRole(user.getRole());
	      
	      //role.setRoleId(user.getId());
	      
	      System.out.println("after setting roleid to user"+role.getRoleId());
	      
	      Set<Role> roleList = new HashSet<Role>();
	      roleList.add(role);
	      user.setRoles(roleList);
	      
	    
			
		
		
		 if (bindingResult.hasErrors() || (!user.getPassword().equals(user.getConfirmPassword())))
		 {
			System.out.println("bindingResult"+bindingResult);
			
			return "register";
		   
		 }
		 else
		 {
			 System.out.println("save into db");
			 userRepository.save(user);
			 return "redirect:/secured/register";
			 	 
		 }
		
	}
	
	
	
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/login")
	public String login(HttpServletRequest request)
	{
		
		
		
		System.out.println(request.getRemoteUser());
		
		
		
		
		
		return "home";
	}
	
	
	
	
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/secured/loginUser")
	public String loginUser(HttpServletRequest request)
	{
		
		
		
		System.out.println(request.getRemoteUser());
		
		
		return "homeUser";
	}
	

	
	
	

   
}
