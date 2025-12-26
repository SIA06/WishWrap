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

@Controller
public class Forgot_password 
{

	@Autowired
	UserRepo userRepo;
	
	
	@GetMapping("/forgot-password")
	public String forgot_passwords()
	{
		return "ForgotPassword";
	}
	
	@PostMapping("/forgot-password")
	public String check(@RequestParam String email,@RequestParam String securityAnswer,Model model)
	{
		Optional<UserEntity> op=userRepo.findByEmail(email);
		if(op.isPresent())
		{
			UserEntity userdb=op.get();
			if(userdb.getSeqAns().equals(securityAnswer))
			{
				model.addAttribute("email", email);  
				return "reset-password";
			}
			
		}
		model.addAttribute("message", "Invalid email or security answer!!");
		return "ForgotPassword";
	}
	
	@GetMapping("/reset-password")
	public String reset_password()
	{
		return "reset-password";
	}
	
	@PostMapping("/reset-password")
	public String change_password(@RequestParam String email,@RequestParam String newPassword,@RequestParam String confirmPassword,Model model)
	{
		
			
			// 1. Password match check
		    if (!newPassword.equals(confirmPassword)) 
		    {
		        model.addAttribute("message", "❌ Passwords do not match");
		        model.addAttribute("email", email);
		        return "reset-password";
		    }
		    
		 // 2. Password length check
		    if (newPassword.length() < 6) 
		    {
		        model.addAttribute("message", "❌ Password must be at least 6 characters");
		        model.addAttribute("email", email);
		        return "reset-password";
		    }
		    else
		    {
		    	Optional<UserEntity> op=userRepo.findByEmail(email);
				if(op.isPresent())
				{
					UserEntity userdb=op.get();
					userdb.setPassword(newPassword);
					userRepo.save(userdb);
					model.addAttribute("message", "✅ Password updated successfully");
					return "redirect:/login";
				
				}
				else
				{
					model.addAttribute("message", "❌ User not found");
				    model.addAttribute("email", email);	
				    return "reset-password";
				}
		    }
		    
	}
	
}
