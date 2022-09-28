package com.bham.pij.assignments.resultchecker;

import java.util.Scanner;

public class ResultChecker {

	public static void main(String[] args) {

		//array to store grades
		
		int grades[] = new int[8];
		
		ResultChecker rc = new ResultChecker();

		for(int i = 0; i < 8; i++) {
		
					System.out.println("Input the grade for module " + (i + 1));

					grades[i] = rc.getInput();

					if(rc.isValid(grades[i]) == false) { 

						System.out.println("The input grade is not between 0 and 100 inclusive, therefore is invalid.");
					
						System.exit(0);
			
					}
		}
		
		System.out.println("Please enter the project grade");
		
		int projectGrade = rc.getInput();
		
		System.out.println(rc.getResult(grades, projectGrade));

	}
	
	public String getResult(int[] grades, int projectGrade) {
		
		ResultChecker rc = new ResultChecker();
		
		for(int i = 0; i < 7; i++) {
			
			if(rc.isValid(grades[i]) == false | rc.isValid(projectGrade) == false) {
			
				return "ERROR";
		
			}
			
			if(grades[i] < 40 == true | (projectGrade < 40) == true ) {
				
				return "FAIL";
			
			}
	
		}
		
		double mean = rc.computeMean(grades, projectGrade);
		
		if((mean < 50) | (projectGrade < 50)) {
			
			return "PASS";
			
		}
		
		if((mean >= 50) && (projectGrade >= 50) == true) {
			
			return "MERIT";
			
		}
		
		else {
			
			return null;
			
		}
		
	}

	private int getInput() {

		//scanner used to read in integers from the keyboard
			    
		Scanner inputscanner = new Scanner(System.in);

		int value = inputscanner.nextInt();
		
		return value;
		}

	public boolean isValid(int grade) {
		
		//if grade is in the range 0 to 100 inclusive return true
		
		if ((grade >=0) && (grade <=100)) {	

			return true;	

		}
		
		else {
			
			return false;
		}
		
	}
	
	public double computeMean (int[] grades, int projectGrade) {
		
				double total = 0;
			
			//validate each grade. Return -1 if invalid grade present, otherwise return mean of the grades

				for(int i = 0; i < grades.length; i++) {

					if(isValid(grades[i]) == false) {
				
						return -1; 

					}

					else {

						total = total + grades[i];
					
					}
				
				}

				total = total + projectGrade;
				
				double mean = total / (grades.length + 1);

				return mean;

	}
	}