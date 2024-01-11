package com.myproject.votingapp.entities;

public class admin {
	private String username;
	private String password;
	public admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "admin [username=" + username + ", password=" + password + "]";
	}
	
}
