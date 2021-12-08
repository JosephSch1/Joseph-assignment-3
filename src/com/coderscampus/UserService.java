package com.coderscampus;

public class UserService {
	static int userIndex;

	public static String verifyUsername(String inputUsername) {
		UserPojo data = new UserPojo();
		String usernameValidity = "";
		String[] validUser = data.username;
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
		UserPojo data = new UserPojo();
		String[] validPassword = data.password;
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
		UserPojo data = new UserPojo();
		String name = data.name[userIndex];
		return name;
	}
}