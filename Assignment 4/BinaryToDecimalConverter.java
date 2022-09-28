package com.bham.pij.assignments.converters;

public class BinaryToDecimalConverter extends AbstractConverter {

	/**
	 * Used for converting 8 bit unsigned binary integers to decimal numbers
	 * between 0 - 255
	 * 
	 */
	
	/**
	 * Converts a binary number to a decimal number
	 * @param value - The binary number to convert
	 * @return - The converted decimal number
	 * @throws InvalidFormatException
	 */
	
public String convert(String binary) throws InvalidFormatException {
		
	//string used to store the current decimal number
	
		int decimal = 0;
		
		int binarylength = 8;
		
		try {
			
			//checks that the binary number contains exactly 8 bits
			
			if(binary.length() != 8) {
				
				throw new InvalidFormatException();
				
			}
			
			//checks that the binary number only contains 0's and 1's
			
			if((binary.matches(".*[01].*")) == false) {
				
				throw new InvalidFormatException();
				
			}
			
			//iterates through each binary bit, adding its associated value to decimal
			//if it is a 1
			
			for(int i = 0; i < binarylength; i++) {
				
				//gets the numerical value of the current binary bit (will be either
				//a 0 or a 1)
				
				int currentelement = Character.getNumericValue(binary.charAt(i));
				
				//if the current bit is a 1, add its respective value to decimal
				
				if(currentelement == 1) {
					
				decimal = decimal + PowerofTwo((binarylength - i - 1));
						
				}
				
			}
		
		}
		
		catch(InvalidFormatException e) {
			
			throw e;
			
		}
		
		//returns the converted decimal
		
		return Integer.toString(decimal);
		
	}
	
}
