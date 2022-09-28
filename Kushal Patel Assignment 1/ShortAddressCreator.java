package com.bham.pij.assignments.shortaddresscreator;

import java.util.Scanner;

public class ShortAddressCreator {

	public static void main(String[] args) {

		ShortAddressCreator sac = new ShortAddressCreator();
		
		String input = sac.getInput();
		
		sac.createShortAddress(input);
		
	}
	
	public String createShortAddress(String input) {
		
		if((input.equals(null)) | (Integer.toString(input.length()).equals("0"))) {
			
			return null;
			
		}
		
		int lastcomma = 0;
		
		int nextcomma = 0;
		
		char addresscharacters[] = input.toCharArray();
		
		String postcode = "";
		
		String addressfirstline = "";
		
		for(int i = 0; i < addresscharacters.length; i++) {
			
			if(addresscharacters[i] == ',') {
				
				lastcomma = nextcomma;
				
				nextcomma = i;
				
				if(lastcomma == 0) {
					
					addressfirstline = input.substring(0, i);
					
				}
				
				if(addresscharacters[i + 1] != ' ') {
					
					return null;
					
				}
				
			}
			
				if(((i - nextcomma) == 7) & (i == (addresscharacters.length - 1))) {
					
					if(isValidPostcode(input.substring(nextcomma + 1, i + 1))) {
						
						postcode = input.substring(nextcomma + 1,i + 1);
						
						return addressfirstline + postcode;
						
					}
					
				}
				
			}
		
		return null;
		
	}
	
	private Boolean isValidPostcode(String unvalidatedpostcode) {
		
		char unvalidatedpostcodeletters[] = unvalidatedpostcode.toCharArray();
		
		if(((unvalidatedpostcodeletters[0] == ' ') & (Character.isLetter(unvalidatedpostcodeletters[1]) & (Character.isDigit(unvalidatedpostcodeletters[2])) & (Character.isDigit(unvalidatedpostcodeletters[3])) & (Character.isDigit(unvalidatedpostcodeletters[4])) & (Character.isLetter(unvalidatedpostcodeletters[5])) & (Character.isLetter(unvalidatedpostcodeletters[6]))))) {
		
			return true;
			
		}
		
		else {
			
			return false;
			
		}
		
	}

	private String getInput() {
			    
		Scanner inputscanner = new Scanner(System.in);

		String inputstring = inputscanner.nextLine();
		
		return inputstring;
		
	}
	
}
