package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
	static int userIndex;
	
	User[] users = new User[4];
	
	public UserService() {
		readUsersFromFile();
	}
	
	public void readUsersFromFile() {
		int i = 0;
		String line = "";
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			while ((line = fileReader.readLine()) != null) {
				String[] userInfo = line.split(",");
				String userName = userInfo[0];
				String password = userInfo[1];
				String name = userInfo[2];
				users[i] = new User(userName, password, name);
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Encountered a problem locating the file");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Encountered an IO exception");
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("IO exception at readFile");
				e.printStackTrace();

			}
		}

	}
	
	public User getValidUser(String userNameInput, String passwordInput) {
		for (int i = 0; i < users.length; i++) {
			User user = users[i];
			if (userNameInput.equalsIgnoreCase(user.getUserName()) && passwordInput.equals(user.getPassword())) {
				return user;					
	}
	}
		return null;
	}
	
	}
