package com.myproject.votingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.myproject.votingapp.dao.registerRepository;
import com.myproject.votingapp.dao.userRepository;


@SpringBootApplication
public class VotingAppDemo {     

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(VotingAppDemo.class, args);
		userRepository userrepository = context.getBean(userRepository.class);
		registerRepository registerrepository = context.getBean(registerRepository.class);
		
		
	}

}
