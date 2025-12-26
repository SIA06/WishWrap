package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.UserEntity;
import com.repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class loginController
{
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	
	@PostMapping("/login")
	public String aunthenticate(@RequestParam String email,@RequestParam String password,HttpSession session,Model model)
	{
		//find by email
		Optional<UserEntity> op=userRepo.findByEmail(email);
		if(op.isPresent())
		{
			UserEntity userdb=op.get();
			if(password.equals(userdb.getPassword()))
			{
				String role=userdb.getRole().getRoleName().toLowerCase();
				session.setAttribute("user", userdb);
	            session.setAttribute("role", role);
	            
	            switch(role)
	            {
	            case "admin":
	            	return "admin-dashboard";
	            
	            case "delivery":
	            	return "delivery-dashboard";
	            
	            case "customer":
	            	return "home";
	            
	            default:
	            	return "login";
	            }
			}	
		}
		model.addAttribute("message", "INVALID EMAIL OR PASSWORD!!");
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) 
	{
	    session.invalidate();  
	    return "redirect:/login";
	}
	
}
