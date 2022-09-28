package com.bham.pij.assignments.gradechecker;

import java.util.Scanner;

public class GradeChecker {

    private static final int PASS_MARK = 40;

	public static void main(String[] args) {
	    
		GradeChecker gc = new GradeChecker();
		
		int grade = gc.getInput();
		
		if (!gc.isValid(grade)) {
            
	  		System.out.println("Invalid input.");

			return;		    
		}

		gc.checkInput(grade);
	}
	
	private void checkInput(int grade) {
		if (isPass(grade)) {
			System.out.println("Pass.");
		}

		else  {
			System.out.println("Fail.");
		}
	}

	public int getInput() {
	    
		Scanner in = new Scanner(System.in);

		System.out.println("Input a grade to check.");

		int val = in.nextInt();

		in.close();
		
		return val;
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

	public boolean isPass(int grade) {
	

        	// if grade is 40 or above return true
		
		if (grade>=40) {
		
			return true;

		}

		//else return false	

		else {

			return false;
		
		}
	}
}
