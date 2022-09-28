package com.bham.pij.assignments.legacycleaner;

import java.util.Scanner;

public class LegacyCleaner {

	public static void main(String[] args) {

		LegacyCleaner lg = new LegacyCleaner();

		String input = lg.getInput();

		String output[] = lg.clean(input);

	}
	
	public String[] arrange(String input[]) {
		
		String name = null;
		
		String id = null;
		
		String result = null;
		
		String postcode = null;
	
		for(int i = 0; i < input.length; i++) {
			
			if(input[i] != null) {
			
			Boolean categoryfound = false;
			
			while(categoryfound == false) {
				
			if((input[i].equals("FAIL") == true) | (input[i].equals("PASS") == true) | (input[i].equals("MERIT") == true)) {
				
				result = input[i];
				
				categoryfound = true;
				
			}
			
			Boolean onlylowercase = true;
			
			Boolean onlyuppercase = true;
			
			Boolean containsdigits = false;
			
			Boolean containsonlyletters = true;
			
			for(int j = 0; j < input[i].length(); j++) {
				
				if(Character.isLowerCase(input[i].charAt(j)) == false) {
					
					onlylowercase = false;
					
				}
				
				if(Character.isUpperCase(input[i].charAt(j)) == false) {
					
					onlyuppercase = false;
					
				}
				
				if(Character.isDigit(input[i].charAt(j)) == true) {
					
					containsdigits = true;
				}
				
				if((Character.isLetter(input[i].charAt(j)) == false) && (input[i].equals(" ") == true)) {
					
					containsonlyletters = false;
					
				}
				
			}
			
			if((containsonlyletters == true) & (containsdigits == false) & (categoryfound == false)) {
				
				name = input[i];
				
				categoryfound = true;
				
			}
			
			if((input[i].length() == 7) & (containsonlyletters == true) & (containsdigits == true)) {
				
				id = input[i];
				
				categoryfound = true;
				
			}
			
			if((input[i].length() == 6) & (containsonlyletters == true) & (containsdigits == true)) {
				
			
				postcode = input[i];
				
				categoryfound = true;
				
			}
			
			categoryfound = true;
			
			}
			}
		}
	
		input[0] = name;
		input[1] = id;
		input[2] = result;
		input[3] = postcode;
		
		return input;
		
	}

	public String[] clean(String input) {

		String arraytooutput[] = separateelements(input);

		arrange(arraytooutput);
		
		return arraytooutput;

	}

	private String[] separateelements(String input) {

		String elements[] = new String[4];

		int currentelement = 0;

		int lastcomma = 0;

		int nextcomma = -1;

		Boolean commadetected = false;
		
		for (int i = 0; i < input.length(); i++) {

			if (Character.toString(input.charAt(i)).equals(",")) {

				commadetected = true;
				
				lastcomma = nextcomma + 1;

				nextcomma = i;

				String stringtosave = input.substring(lastcomma, nextcomma);
				
				if((stringtosave.contains(",") == false) && (stringtosave.length() > 1)) {
					
					elements[currentelement] = stringtosave;
					
					currentelement++;

				}

			}

			if (i == (input.length() - 1)) {
					
					if(commadetected == true) {
				
						lastcomma = nextcomma + 1;
		
						String stringtosave = input.substring(lastcomma, i + 1);
						
						if((stringtosave.contains(",") == false) && (stringtosave.length() > 1)) {
							
							elements[currentelement] = stringtosave;
							
						}
				
					}

			}

		}

		for (int i = 0; i < elements.length; i++) {
			
			if(elements[i] != null) {
			
				elements[i] = elements[i].trim();
			
			}

		}

		return elements;

	}

	private String getInput() {

		Scanner inputscanner = new Scanner(System.in);

		String inputstring = inputscanner.nextLine();

		return inputstring;

	}

}
