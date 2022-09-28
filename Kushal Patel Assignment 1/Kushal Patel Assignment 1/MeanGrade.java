package com.bham.pij.assignments.meangrade;

import java.util.Scanner;

public class MeanGrade {

	//constant which stores number of modules; program could be adapted to handle any number of grades

	private static final int NUMBER_OF_MODULES = 4;	

		public static void main(String[] args) {

			//array to store grades
			
			int grades[] = new int[NUMBER_OF_MODULES];		
		
			MeanGrade mg = new MeanGrade();
			
			//loop used to input grade for each module. Number of repeats dependent on NUMBER_OF_MODULES constant			

			for(int i = 0; i < NUMBER_OF_MODULES; i++) {
		
					System.out.println("Input the grade for module " + (i + 1));

					grades[i] = mg.getInput();

					if(mg.isValid(grades[i]) == false) { 

						System.out.println("The input grade is not between 0 and 100 inclusive, therefore is invalid.");
					
						System.exit(0);
			
					}
			}	

			//mean of grades calculated and output

			System.out.println("The mean of the " + NUMBER_OF_MODULES + " modules which you have entered is: " + mg.computeMean(grades) + ".");

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

		//else return false

		else {
	
			return false;

		}
		
		}

		public double computeMean (int[] grades) {

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

			double mean = total / grades.length;

			return mean;

		}
}