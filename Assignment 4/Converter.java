package com.bham.pij.assignments.converters;

import java.util.ArrayList;

/**
 * @author Kushal_Patel
 *
 */

/*
 * Converter object generated from this class is used to generate and use
 * 
 * the methods of an object of type AbstractConverter which is instantiated from
 * 
 * a class specific to which conversion is taking place (see comments at the top 
 * 
 * of AbstractConverter class).
 * 
 */

public class Converter extends Object {
	
	/**
	 * A class for converting between number bases.
	 *
	 *Methods inherited from class Object - clone, equals,
	 *finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait
	 *
	 */
	
	/**
	 * Attributes
	 */

	public static enum ConvertMode {BIN2HEX, HEX2BIN, BIN2DEC, DEC2BIN};
	
	// AbstractConverter object which will become an object more appropriate
	// to the conversion which is taking place
	
	private AbstractConverter converterObject;
	
	/**
	 * Constructor + Methods
	 */
	
	/**
	 * Constructor which sets the converter mode
	 * @param cm - The ConvertMode to use for this converter
	 */
	
	public Converter(Converter.ConvertMode cm) {
		
		//switch statement used in order to determine which conversion
		//is taking place and create an object from the appropriate class
		
		switch (cm)
		{
		
		case HEX2BIN:
			converterObject = new HexadecimalToBinaryConverter();
			break;
			
		case BIN2HEX:
			converterObject = new BinaryToHexadecimalConverter();
			break;
		
		case BIN2DEC:
			converterObject = new BinaryToDecimalConverter();
			break;
			
		case DEC2BIN:
			converterObject = new DecimalToBinaryConverter();
			break;
		
		}
		
	}
	
	/**
	 * Get the input values from the file, if any
	 * @return - the input values. Returns an empty list if there are no input values
	 */
	
		public ArrayList<String> getInputValues() {
			
			return converterObject.getInputValues();
			
		}
		
	/**
	 * Get the output values obtained from applying the conversion to all of the
	 * values in the file, if any
	 * @return - the output values. Returns an empty list if there are no output
	 * values
	 */
		
		public ArrayList<String> getOutputValues() {
			
			return converterObject.getOutputValues();
			
		}
		
	/**
	 * Loads the file given in the parameter and converts all of the numbers in the
	 * file according to the selected ConvertMode. The input values and the converted
	 * values will be stored for retrieval by the getInputValues() and getOutputValues()
	 * methods
	 * @param filename - The file containing the numbers to convert
	 */
		
		public void fromFile(String filename) {
			
			converterObject.fromFile(filename);
			
		}
		
	/**
	 * Converts the number in the parameter according to the selected ConvertMode
	 * @param value - The number to convert
	 * @return - The number converted to the base defined by the selected ConvertMode
	 * @throws InvalidFormatException
	 */

		public String convert(String value) throws InvalidFormatException {
				
			return converterObject.convert(value);

		}
		
}
