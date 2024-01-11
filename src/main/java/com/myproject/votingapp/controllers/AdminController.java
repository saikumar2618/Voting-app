package com.myproject.votingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.votingapp.services.registerservice;

@Controller
public class AdminController {
	
	@Autowired
	private registerservice registerserve;
	
//	@RequestMapping(value="/admin", method = RequestMethod.GET)
//	public String admin() {
//		return "admin";
//	}
	
	@PostMapping("/admin")
	public String admin() {
		
		return "admin";
	}
}
