package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		int attempts = 1;
		UserService app = new UserService();
		Scanner sc = new Scanner(System.in);
		String userValidity = "invalid";
		String passValidity = "invalid";

		while (attempts < 5 && passValidity.equals("invalid")) {
			userValidity = checkUserValidity(sc);
			passValidity = checkPassValidity(sc);
			if (passValidity.equals("invalid") || userValidity.equals("invalid")) {
				userValidity = "invalid";
				passValidity = "invalid";
				attempts++;
				if (attempts < 5) {
					System.out.println("Invalid login, please try again");
				}
			}
		}

		String name = app.name();
		if (passValidity.equals("valid")) {
			System.out.println("Welcome: " + name);
		}
		if (attempts >= 4) {
			System.out.println("Too many failed attempts, you are locked out.");
		}
	}

	public static String checkUserValidity(Scanner sc) {
		UserService app = new UserService();
		System.out.println("Enter your email: ");
		String inputEmail = sc.nextLine();
		String usernameValidity = app.verifyUsername(inputEmail);
		return usernameValidity;
	}

	public static String checkPassValidity(Scanner sc) {
		UserService app = new UserService();
		System.out.println("Enter your password: ");
		String inputPassword = sc.nextLine();
		String passValidity = app.verifyPassword(inputPassword);
		return passValidity;
	}
}