package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserPojo {
String[] username = validUsername();
String[] password = validPassword();
String[] name = validName();
	
	public static String[] readFile() {
		int i = 0;
		String line = "";
		String[] data = new String[4];
	BufferedReader fileReader = null;
	try {
	fileReader = new BufferedReader(new FileReader("data.txt"));
	while ((line = fileReader.readLine()) != null) {
	data[i] = line;
	i++; 
	}
	} catch (FileNotFoundException e) {
		System.out.println("Encountered a problem locating the file");
		e.printStackTrace();
	} 
	catch (IOException e) {
		e.printStackTrace();
		System.out.println("Encountered an IO exception");
	} finally {
		try {
			fileReader.close();
		} catch (IOException e) {
			System.out.println("IO exception at readFile");
			e.printStackTrace();
		}
		return data;
 }

	}
	
	public static String[] validUsername() { //returns an array of valid usernames from the txt file
		
		String[] txt = readFile();
		String eachLine = "";
		String[] lineArray;
		String [] username = new String[txt.length];
		for (int i = 0; i < txt.length; i++) {
			eachLine = txt[i];
			lineArray = eachLine.split(",");
			username[i] = lineArray[0];
		}
		return username;
	}
	
	public static String[] validPassword() { //returns an array of valid passwords from the txt file
		
		String[] txt = readFile();
		String eachLine = "";
		String[] lineArray;
		String [] password = new String[txt.length];
		for (int i = 0; i < txt.length; i++) {
			eachLine = txt[i];
			lineArray = eachLine.split(",");
			password[i] = lineArray[1];
		}
		return password;
	}
	
	public static String[] validName() { //returns an array of valid names from the txt file
		
		String[] txt = readFile();
		String eachLine = "";
		String[] lineArray;
		String [] name = new String[txt.length];
		for (int i = 0; i < txt.length; i++) {
			eachLine = txt[i];
			lineArray = eachLine.split(",");
			name[i] = lineArray[2];
		}
		return name;
	}
}
