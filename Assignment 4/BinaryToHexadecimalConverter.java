package com.bham.pij.assignments.converters;

import java.util.ArrayList;

public class BinaryToHexadecimalConverter extends AbstractConverter {

	/**
	 * Used for converting 8 bit unsigned binary integers to decimal numbers
	 * between 0 - 255
	 * 
	 */
	
	/**
	 * Converts a binary number to a hexadecimal number
	 * @param value - The binary number to convert
	 * @return - The converted hexadecimal number
	 * @throws InvalidFormatException
	 */
	
public String convert(String binary) throws InvalidFormatException {
		
	//used to store the two nibbles of the binary string
	
	ArrayList<String> elements = new ArrayList<String>();
	
	//used to store the converted hexadecimal number

	String hexadecimal = "";
	
	//array of possible values which each digit of the hexadecimal number may take
	
	String[] hexadecimalValues = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
	
	//array of valid binary nibbles (used later for validation)
	
	String[] validNibbles = {"1111", "1110", "1101", "1100", "1011", "1010", "1001", "1000", "0111", "0110", "0101",
			"0100", "0011", "0010", "0001", "0000"};
	
	//BinaryToDecimalConverter object instantiated to convert nibbles into decimals
	//used during mapping of each nibble to a hexadecimal digit
	//enables reuse of prewritten code to convert a binary number to a decimal number
	
	BinaryToDecimalConverter B2DConverter = new BinaryToDecimalConverter();
	
		try {
			
			//checks that the binary number contains exactly 8 bits
			
			if(binary.length() != 8) {
				
				throw new InvalidFormatException();
				
			}
			
			//adds each nibble of the 8 bit binary string to the elements ArrayList
			
			elements.add(binary.substring(0,4));
			
			elements.add(binary.substring(4,8));
			
			//boolean variables used to store whether each nibble has been found
			//to be valid
			
			Boolean nibbleOneValid = false;
			
			Boolean nibbleTwoValid = false;
			
			//loop checks each nibble against the array of nibbles
			//if a nibble is found in the array of valid nibbles, its respective
			//boolean variable is set to true
			
			for(int i = 0; i < validNibbles.length; i++) {
				
				if(elements.get(0).contentEquals(validNibbles[i])) {
					
					nibbleOneValid = true;
					
				}
	
				if(elements.get(1).contentEquals(validNibbles[i])) {
					
					nibbleTwoValid = true;
					
				}
				
			}
			
			//checks if any of the nibbles have been found to be invalid
			
			if((nibbleOneValid && nibbleTwoValid) == false) {
				
				throw new InvalidFormatException();
				
			}
			
			//converts each nibble into its corresponding decimal value
			//
			//uses the BinaryToDecimalConverter convert() method to do so
			//four 0's are added to the start of each nibble to make them 8 bits long
			//in order for them to be in a valid format to be used by this method
			
	        int firstNibbleDecimal = Integer.parseInt(B2DConverter.convert("0000" + elements.get(0)));
	        
	        int secondNibbleDecimal = Integer.parseInt(B2DConverter.convert("0000" + elements.get(1)));
		
			//corresponding hexadecimal digit for each nibble is in the position of its decimal value
	        //within the hexadecimalValues array
	        //
	        //the two hexadecimal digits are combined and stored
	        
			hexadecimal = hexadecimalValues[firstNibbleDecimal] + hexadecimalValues[secondNibbleDecimal];
		
		}
		
		catch(InvalidFormatException e) {
			
			throw e;
			
		}
		
		//returns the converted hexadecimal
		
		return hexadecimal;
		
	}
	
}