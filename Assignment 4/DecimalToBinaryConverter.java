package com.bham.pij.assignments.converters;

public class DecimalToBinaryConverter extends AbstractConverter {
	
	/**
	 * Used for converting decimal numbers between 0 - 256 to
	 * 8 bit unsigned binary integers
	 */
	
	/**
	 * Converts a decimal number to a binary number
	 * @param value - The decimal number to convert
	 * @return - The converted binary number
	 * @throws InvalidFormatException
	 */
	
	public String convert(String value) throws InvalidFormatException {
		
		//string used to store the converted binary number
		
		String binary = "";
		
		int binaryLength = 8;
		
		try {
			
			//checks that the decimal number only contains digits 0-9
			
			if(value.matches(".*[0123456789].*") == false) {
				
				throw new InvalidFormatException();
				
			}
			
			//checks that the decimal number is between 0 and 255
			
			int decimal = Integer.parseInt(value);
			
			if((decimal < 0) || (decimal > 255)) {
				
				throw new InvalidFormatException();
				
			}
			
			//Loop used to generate a binary number from the given decimal number.
			//
			//Starts at the largest power of two in the 8 bits (2^7)
			//and if the given power of two is less than the value of the decimal,
			//a 1 is added to the binary string, otherwise a 0 is added. If a 1 is
			//added, the current power of two is subtracted from the decimal.
			//
			//Process repeats until all 8 bits have been considered
			
			for(int i = 0; i < binaryLength; i++) {
				
				//currentpower keeps track of the value of the current bit of binary
				//being processed
				
				int currentpower = PowerofTwo(binaryLength - i - 1);
				
				//if decimal is greater than currentpower,
				//the current bit needs to be a 1
				
				if(decimal >= currentpower) {
					
					binary = binary + "1";
					
					decimal = decimal - currentpower;
					
				}
				
				//otherwise the current bit needs to be a 0
				
				else {
					
					binary = binary + "0";
					
				}
				
			}
			
		}
		
		catch(InvalidFormatException e) {
			
			throw e;
			
		}
		
		//returns the generated binary string
		
		return binary;
		
	}

}
