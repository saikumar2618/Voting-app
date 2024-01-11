package com.myproject.votingapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproject.votingapp.dao.registerRepository;
import com.myproject.votingapp.dao.userRepository;
import com.myproject.votingapp.entities.participants;
import com.myproject.votingapp.entities.user;

@Component
public class userservice {
	
	@Autowired
	private userRepository userrepository;
	@Autowired
	private registerRepository register;
	
	public void updatecount(String name,String candidate) {
		
		register.setVoted(candidate, name);
//		System.out.println(candidate);
		userrepository.setCount(candidate);
//		System.out.println(userrepository.getByCount(candidate));
		
	}
	
	
	
	
	
	
	
	
	
//	public void updatecount(participants part) {
//		
//		System.out.println("trying..");
//		int count = userrepository.getByCount(part.getId());
//		System.out.println(count);
//		count=count+1;
//		part.setCount(count);
//		
//		
////	/*	user myuser = new user();
////		myuser.setId(id);
////		myuser.setVoted(part.getName());
////		user res = register.save(myuser);
//		
////		user myuser = register.getByUser(id);
////		myuser.setVoted(part.getName());
////		user res = register.save(myuser);  */
//		participants result = userrepository.save(part);
//		System.out.println(result);
//		
//		
//	}
	
	
	
}
