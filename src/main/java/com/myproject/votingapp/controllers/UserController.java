package com.myproject.votingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.votingapp.entities.participants;
import com.myproject.votingapp.services.userservice;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class UserController {
	
	@Autowired
	private loginController login;
	@Autowired
	private userservice userserve;

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user() {
		return "user";
	}
	
//	@PutMapping("/user")
//	public participants updatevote(@RequestBody participants part) {
//		userserve.updatecount(part);
//		return part;
//	}
	
	@PostMapping("/updateUser")
	public String updatevote(@RequestParam("candidate") String candidate) {
		userserve.updatecount(login.username,candidate);
		return "redirect:/invalidate/session";
	}
	
	@PostMapping("/invalidate/session")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/loginpage";
    }
	
	@GetMapping("/invalidate/session")
    public String destroymySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/loginpage";
    }
}
