package com.bham.pij.assignments.converters;

public class HexadecimalToBinaryConverter extends AbstractConverter {
	
	/**
	 * Used for converting hexadecimal numbers to 8 bit unsigned binary integers
	 * 
	 */
	
	/**
	 * Converts a hexadecimal number to a binary number
	 * @param value - The hexadecimal number to convert
	 * @return - The converted binary number
	 * @throws InvalidFormatException
	 */

public String convert(String hexadecimal) throws InvalidFormatException {
	
	//used to store the two binary nibbles obtained from the converted hexadecimal digits
		
	String elementOneBinary = "";
	
	String elementTwoBinary = "";
	
	//used to store the converted binary
	
	String binary = "";
	
	//array of possible values which each digit of the hexadecimal number may take
	
	String[] hexadecimalValues = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
	
	//DecimalToBinaryConverter object instantiated to convert decimals into nibbles
	//used during mapping of each hexadecimal digit to a binary nibble
	//enables reuse of prewritten code to convert a decimal number to a binary number
	
	DecimalToBinaryConverter Dec2Bin = new DecimalToBinaryConverter();
	
	try {
		
		//checks that hexadecimal contains exactly 2 digits
		
		if(hexadecimal.length() != 2) {
			
			throw new InvalidFormatException();
			
		}
		
		//digits that hexadecimal only contains valid characters
		
		if(hexadecimal.matches(".*[0123456789ABCDEF].*") == false) {
			
			throw new InvalidFormatException();
			
		}
		
		//loop checks each hexadecimal digit against array of hexadecimal values
		//if a hexadecimal digit matches an element in the array of hexadecimal
		//values, the value of that digit is equivalent to its ordinal number
		//in the array
		//once this number is known, it is converted into binary
		//the generated binary is stored in the elementOneBinary and elementTwoBinary
		//variables
		
		for(int i = 0; i < 16; i++) {
			
		    if(Character.toString(hexadecimal.charAt(0)).equals(hexadecimalValues[i])) {
		    	
		    	elementOneBinary = Dec2Bin.convert(Integer.toString(i)).substring(4, 8);
					
			}
				
			if(Character.toString(hexadecimal.charAt(1)).equals(hexadecimalValues[i])) {
					
				elementTwoBinary = Dec2Bin.convert(Integer.toString(i)).substring(4, 8);
					
			}
			
		}
		
	//binary for the two hexadecimal digits is combined and stored
	
	binary = elementOneBinary + elementTwoBinary;
	
	}
		
	catch(InvalidFormatException e) {
			
		throw e;
	
	}
	
	//return the converted binary
	
	return binary;
		
}
	
}
