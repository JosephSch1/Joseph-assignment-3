package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		int attempts = 0;
		UserService app = new UserService();
		Scanner sc = new Scanner(System.in);
		boolean isUserFound = false;
		
		while (attempts < 5 && !isUserFound) {
			User user = checkUserValidity(sc);
			
			if (user == null) {
					System.out.println("Invalid login, please try again");
					attempts++;
			} else {
				isUserFound = true;
				System.out.println("Welcome: " + user.getName());
				break;
			}
		}

		if (!isUserFound) {
			System.out.println("Too many failed attempts, you are locked out.");
		}
	}

	public static User checkUserValidity(Scanner sc) {
		UserService userService = new UserService();
		System.out.println("Enter your email: ");
		String inputEmail = sc.nextLine();
		System.out.println("Enter your password: ");
		String inputPassword = sc.nextLine();
		return userService.getValidUser(inputEmail, inputPassword);
	}
}