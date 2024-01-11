package com.myproject.votingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.votingapp.entities.user;
import com.myproject.votingapp.services.registerservice;
import com.myproject.votingapp.validation.allValidations;

@Controller
public class registerController {
	
	@Autowired
	private registerservice registerserve;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
//	@PostMapping("/register")
//	public user adduser(@RequestBody user myuser) {
//		registerserve.addUser(myuser);
//		return myuser;
//	}
	
	@PostMapping("/loginpage")
	public String adduser(@RequestParam("user") String name,
			@RequestParam("pass") String pass,
			@RequestParam("mail") String mail,
			@RequestParam("phone_no") String phone_no) {
		user newuser = new user(name,pass,mail,phone_no);
		allValidations valid= new allValidations();
		if(valid.allcheck(name, pass, mail, phone_no)=="") {
			registerserve.addUser(newuser);
			return "loginpage";
		}else {
			System.out.println(valid.allcheck(name, pass, mail, phone_no));
			return "register";
		}
		
	}
	
//	@RequestMapping("/loginpage")
//	public String back() {
//		List<User> list = new ArrayList<User>();
//		list.getname();
//		list.getvoted
//		return "loginpage";
//	}
	
	

	
}
