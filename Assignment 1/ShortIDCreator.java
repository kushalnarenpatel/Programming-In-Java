package com.bham.pij.assignments.shortidcreator;

import java.util.Random;
import java.util.Scanner;

public class ShortIDCreator {

	public static void main(String[] args) {
		
		ShortIDCreator sic = new ShortIDCreator();
		
		String input = sic.getInput(); 
		
		String generatedID = sic.createID(input);
		
	}
	
	public String createID(String input) {
		
		if(input.equals(null)) {
			
			return null;
			
		}
		
		if(Integer.toString(input.length()).equals("0")) {
			
		return null;
			
		}
		
		int numberofparts = 1;
		
		char[] inputchararray = input.toCharArray();
		
		for(int i = 0; i < inputchararray.length; i++) {
			
			if(Character.toString(inputchararray[i]).equals(" ")) {
				
				numberofparts++;
				
			}
			
		}
		
		if((numberofparts < 2 == true) | (numberofparts > 3 == true)) {
			
			return null;
			
		}
		
		String[] names = new String[numberofparts];
		
		int currentword = 0;
		
		int endoflastword = 0;
		
		for(int i = 0; i < inputchararray.length; i++) {
			
			if(Character.toString(inputchararray[i]).equals(" ")) {
				
				names[currentword] = input.substring(endoflastword,i);
				
				currentword++;
				
				endoflastword = i + 1;
				
			}
			
			if(Integer.toString(i).equals(Integer.toString(inputchararray.length - 1))) {
				
				names[currentword] = input.substring(endoflastword, i + 1);
				
			}
			
		}
		
		char firstletterofnames[] = new char[numberofparts];
		
		for(int i = 0; i < names.length; i++) {
			
			firstletterofnames[i] = names[i].charAt(0);
			
		}
		
		String ShortID = "";
		
		if(numberofparts == 2)
		{
			
			String firstletterofnamesstring = String.valueOf(firstletterofnames);
			
		    ShortID = insertLetter(firstletterofnamesstring, generateRandomLetter());
			
		}
		
		if(numberofparts == 3) {
			
			ShortID = String.valueOf(firstletterofnames);
			
		}
		
		return ShortID;
		
		}
	
	private char generateRandomLetter() {
		
		Random numbergenerator = new Random();
		
		char randomletter = (char)(numbergenerator.nextInt(26) + 97);
		
		return randomletter;
	}
	
	private String insertLetter(String incompleteID, char generatedletter) {
		
		String completedID = "";
		
		completedID = completedID + incompleteID.charAt(0) + generatedletter + incompleteID.charAt(1);
		
		return completedID;
	}
	
	private String getInput() {
			    
		Scanner inputscanner = new Scanner(System.in);

		String inputstring = inputscanner.nextLine();
		
		return inputstring.toLowerCase();
		
	}

}
