package com.myproject.votingapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproject.votingapp.dao.registerRepository;
import com.myproject.votingapp.dao.userRepository;
import com.myproject.votingapp.entities.user;

@Component
public class registerservice {
	
	@Autowired
	private registerRepository registerrepository;
	
	@Autowired
	private userRepository userrepository;
	
	public int countCandidate1,countCandidate2,countCandidate3,countCandidate4;
	
	public void addUser(user newuser) {
		try {
			newuser.setRole("USER");
			user result = registerrepository.save(newuser);
		}catch(Exception e) {
			e.getMessage();
		}		
		
	}
	
	public String loginuser(String name, String pass) {
//		boolean res=false;
		String res=null;
		String user=registerrepository.getByRole(name);
		if(user.equals("ADMIN")) {
			String password = registerrepository.getPassword(name);
			System.out.println("pass is "+pass +" passwrd is "+password);
			if(pass.equals(password)) {
				countCandidate1 = userrepository.getByCount("candidate1");
				countCandidate2 = userrepository.getByCount("candidate2");
				countCandidate3 = userrepository.getByCount("candidate3");
				countCandidate4 = userrepository.getByCount("candidate4");
				res="admin";
			}
		}else {
			String password = registerrepository.getPassword(name);
			if(password!=null) {
				if(pass.equals(password)) {
					String voted = registerrepository.getByVoted(name);
					if(voted==null) {
						res="user";
					}else {
						res="voteduser";
					}	
				}
			}
		}	
		return res;
	}
	
	public String voted_candid(String name) {
		String voted = registerrepository.getByVoted(name);
		return voted;
	}
}
