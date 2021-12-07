package com.coderscampus;

public class UserService {
	UserPojo txt = new UserPojo();
	static int userIndex;
	
	public static String verifyUsername(String inputUsername) {
		UserPojo txt = new UserPojo();
		String usernameValidity = "";
		String[] validUser = txt.username;
		for (int i = 0; i < validUser.length; i++) {
			if (inputUsername.equalsIgnoreCase(validUser[i])) {
				usernameValidity = "valid";
				userIndex = i;
				break;
			} else {
				usernameValidity = "invalid";
			}
		}
		return usernameValidity;
	}
	
	public static String verifyPassword(String inputPassword) {
		UserPojo txt = new UserPojo();
		String[] validPassword = txt.password;
		String passwordValidity = "";
		for (int i = 0; i < validPassword.length; i++) {
			if (inputPassword.equals(validPassword[i]) && i == userIndex) {
				passwordValidity = "valid";
				break;
			} else {
				passwordValidity = "invalid";
			}
		}
		return passwordValidity;
	}
	
	public static String name() {
		UserPojo txt = new UserPojo();
		String name = txt.name[userIndex];
		return name;
	}
}