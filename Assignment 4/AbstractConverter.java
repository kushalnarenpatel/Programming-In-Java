package com.bham.pij.assignments.converters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * AbstractConverter is the parent class for all the specific conversion
 * classes
 * 
 * Common attributes and methods between the conversion classes are specified within
 * this class
 * 
 */

public abstract class AbstractConverter {
	
	private String fileName;
	
	//ArrayLists storing the input and output values of the conversion
	
	private ArrayList<String> inputValues = new ArrayList<String>();
	
	private ArrayList<String> outputValues = new ArrayList<String>();

	/**
	 * Method for calculating what 2 raised to the power of a certain number is.
	 * Used commonly during conversions.
	 * @param power - the number which 2 will be raised to the power of
	 * @return - the result of raising 2 to the power of the specified number
	 */
	
	protected static int PowerofTwo(int power) {
		
		return (int)Math.pow(2, power);
		
	}
	
	/**
	 * Converts the number in the parameter according to the selected ConvertMode
	 * @param value - The number to convert
	 * @return - The number converted to the base defined by the selected ConvertMode
	 * @throws InvalidFormatException
	 */
	
	public abstract String convert(String value) throws InvalidFormatException;
	
	
	/**
	 * Loads the file given in the parameter and converts all of the numbers in the
	 * file according to the selected ConvertMode. The input values and the converted
	 * values will be stored for retrieval by the getInputValues() and getOutputValues()
	 * methods
	 * @param filename - The file containing the numbers to convert
	 */
	
	public void fromFile(String filename) {
		
		//filename of file is stored within the object
		
		this.fileName = filename;
		
		//file is loaded into inputValues ArrayList
		
		getInputValues();
		
		//file is converted and these values are loaded into outputValues ArrayList
		
		getOutputValues();
		
	}
	
	/**
	 * Get the input values from the file, if any
	 * @return - the input values. Returns an empty list if there are no input values
	 */
	
	public ArrayList<String> getInputValues() {
			
			try {
				
			//removes any existing values from a file
				
			inputValues.clear();
			
			//BufferedReader used to read the file line by line
			
			BufferedReader filereader = new BufferedReader(new FileReader(fileName));
			
			//string used to store the current line of the file being read in
			
			String currentline = "";
			
			//loop adds lines of the file to inputValues ArrayList
				
			while((currentline = filereader.readLine()) != null)
				
					inputValues.add(currentline);
			
			} 
			
			//catches any file reading exceptions and calls printStackTrace()
			
			catch (IOException e) {
			
				e.printStackTrace();
			
			}
			
			return inputValues;
			
	} 
	
	/**
	 * Get the output values obtained from applying the conversion to all of the
	 * values in the file, if any
	 * @return - the output values. Returns an empty list if there are no output
	 * values
	 */
	
	public ArrayList<String> getOutputValues() {
		
		//converts each element of inputValues and adds this
		// the outputValues ArrayList
		
		for(int i = 0; i < inputValues.size(); i++) {
			
			outputValues.add(convert(inputValues.get(i)));
			
		}
		
		//finally returns the outputValues ArrayList
		
		return outputValues;
		
	}
	
}
