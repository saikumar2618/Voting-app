package com.myproject.votingapp.validation;

public class allValidations {
	
	public boolean validateUsername(String username) {
		boolean res=false;
		for(int i=0;i<username.length();i++) {
			if((username.charAt(i)>=65 && username.charAt(i)<=90) || (username.charAt(i)>=97 && username.charAt(i)<=122) 
					|| (username.charAt(i)>=48 && username.charAt(i)<=57)){
						res=true;
					}
					else {
						System.out.println("i m here" + i );
						res=false;
						break;
					}
		}
		
		return res;
	}
	
	public boolean validatePassword(String password) {
		boolean res=false;
		if(password.length()>=5) {
			res=true;
		}
		return res;
	}
	
	public boolean validateGmail(String gmail) {
		String regex = "^[a-z0-9](\\.?[a-z0-9]){5,}@gmail\\.com$";
		if(gmail.matches(regex)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validatePhone(String mobile) {
		String regex = "(0/91)?[7-9][0-9]{9}";
//		String mob=String.valueOf(mobile);
	    if(mobile.matches(regex)) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	public String allcheck(String username, String password, String gmail, String phone) {
		String msg = "";
		if(!validateUsername(username)) {
			msg = msg + "\n Invalid username";
		}
		if(!validatePassword(password)) {
			msg = msg + "\n Password length must be atleast 5 characters";
		}
		if(!validateGmail(gmail)) {
			msg = msg + "\n Invalid Gmail Id";
		}
		if(!validatePhone(phone)) {
			msg = msg + "\n Invalid phone number";
		}
		return msg;
	}

}
