package com.bham.pij.assignments.passwordchecker;

//Take out output

import java.util.Scanner;

public class PasswordChecker {

	public static void main(String[] args) {
		
		PasswordChecker pw = new PasswordChecker();
		
		String input = pw.getInput();

	}
	
	public String checkPassword(String input) {
		
		Boolean passwordok = true;
		
		String passwordfaults[] = new String[5];
		
		char[] passwordcharacters = input.toCharArray();
		
		int faultcounter = 0;
		
		if(input.length() < 8) {
			
			passwordfaults[faultcounter] = "TOO SHORT";
			
			faultcounter++;
			
			passwordok = false;
			
		}
		
		if(input.length() > 12) {
			
			passwordfaults[faultcounter] = "TOO LONG";
			
			faultcounter++;
			
			passwordok = false;
			
		}
		
		Boolean wrongcharacteralert = false;
		
		for(int i = 0; i < passwordcharacters.length; i++) {
			
			if(((Character.isUpperCase(passwordcharacters[i]) == false ) & (Character.isLowerCase(passwordcharacters[i]) == false) & (Character.isDigit(passwordcharacters[i]) == false)) & (Character.toString(passwordcharacters[i]).equals("_") == false)) {
					
					wrongcharacteralert = true;
					
			}
			
		}
			
			if(wrongcharacteralert == true) {
				
				passwordfaults[faultcounter] = "WRONG CHARACTERS";
				
				faultcounter++;
				
				passwordok = false;
				
			}
		
		if(Character.isDigit(input.charAt(0))) {
			
			passwordfaults[faultcounter] = "LEADING DIGIT";
			
			faultcounter++;
			
			passwordok = false;
			
		}
		
		Boolean containsupper = false;
		Boolean containslower = false;
		
		for(int i = 0; i < input.length(); i++) {
			
			if(Character.isLowerCase(passwordcharacters[i])) {
				
				containslower = true;
				
			}
			
			if(Character.isUpperCase(passwordcharacters[i])) {
				
				containsupper = true;
				
			}
			
		}
		
		if((containslower == false) | (containsupper == false)) {
			
			passwordfaults[faultcounter] = "NOT MIXED CASE";
			
			faultcounter++;
				
			passwordok = false;
		
		}
		
		if(passwordok == true) {
			
			return "OK";
			
		}
		
		else {
			
			String recordedfaults = "";
			
			for(int i = 0; i < passwordfaults.length; i++) {
				
				if(passwordfaults[i] != null) {
					
					if(i > 0) {
						
						recordedfaults = recordedfaults + ", ";
						
					}
					
					recordedfaults = recordedfaults + passwordfaults[i];
					
				}
				
			}
			
			return recordedfaults;
			
		}
		
	}

	private String getInput() {
			    
		Scanner inputscanner = new Scanner(System.in);

		String inputstring = inputscanner.nextLine();
		
		return inputstring;
		
	}
	
}