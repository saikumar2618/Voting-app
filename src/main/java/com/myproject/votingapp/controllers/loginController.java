package com.myproject.votingapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.votingapp.services.registerservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class loginController {
	
	protected String username;
	@Autowired
	private registerservice registerserve;
	
	@RequestMapping(value="/loginpage", method = RequestMethod.GET)
	public String login() {
		return "loginpage";
	}
	
	@PostMapping("/user/{name}")
	public String voter(@PathVariable("name") String user, @RequestParam("pass") String pass, Model model,HttpServletRequest request) {
		String person = registerserve.loginuser(user,pass);
		if(person==null) {
			return "loginpage";
		}
		if(person.equals("user")) {
			List<String> names = (List<String>) request.getSession().getAttribute("NAME_SESSION");
	        if (names == null) {
	            names = new ArrayList<>();
	            request.getSession().setAttribute("NAME_SESSION", names);
	        }
	        names.add(user);
	        request.getSession().setAttribute("NOTES_SESSION", names);
			
			
//			HttpSession session =request.getSession();  
//		    session.setAttribute("name",user); 
			model.addAttribute("name",user);
			username=user;
			return "user";
		}else if(person.equals("voteduser")) {
			//System.out.println(request.getSession().getCreationTime());
			if(request.getSession().getId()!=null) {
				HttpSession session =request.getSession();  
			    session.setAttribute("name",user); 
				model.addAttribute("name",user);
				String voted = registerserve.voted_candid(user);
				model.addAttribute("voted",voted);
				return "voteduser";
			}else {
				return "loginpage";
			}
			
		}
		else{
				HttpSession session =request.getSession();  
			    session.setAttribute("name",user); 
				model.addAttribute("candidate1",registerserve.countCandidate1);
				model.addAttribute("candidate2",registerserve.countCandidate2);
				model.addAttribute("candidate3",registerserve.countCandidate3);
				model.addAttribute("candidate4",registerserve.countCandidate4);
				return "admin";
			
		}
		
	}
	
//	@PostMapping("/user/{name}")
//	public String test(@PathVariable("name") String name) {
//		System.out.println(name);
//		return "user";
//	}
	
}
