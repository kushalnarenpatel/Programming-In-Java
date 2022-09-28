package com.bham.pij.assignments.fullidcreator;

import com.bham.pij.assignments.shortidcreator.ShortIDCreator;

import java.util.Scanner;

import java.util.Random;

import com.bham.pij.assignments.shortidcreator.ShortIDCreator;

public class FullIDCreator {

	static String usedshortIDs[] = new String[10000];

	static int usedshortIDcount = 0;

	static String fullID = "";

	static String usedfullIDs[] = new String[10000];

	static int numberofIDscreated = 0;

	public static void main(String[] args) {

		while (true) {

			FullIDCreator fic = new FullIDCreator();

			String input = fic.getInput();

			String generatedID = fic.createFullID(input);

		}

	}

	public String createFullID(String input) {

		ShortIDCreator sic = new ShortIDCreator();

		String shortID = sic.createID(input);

		Boolean shortIDused = false;

		if(shortID != null) {
		
		for (int i = 0; i < usedshortIDcount; i++) {

			if (usedshortIDs[i].equals(shortID)) {

				shortIDused = true;

				i = usedshortIDcount;

			}

		}

		if (shortIDused == false) {

			usedshortIDs[usedshortIDcount] = shortID;

			usedshortIDcount = usedshortIDcount + 1;

		}

		if (shortIDused)

		{

			Boolean uniquefullIDfound = false;

			Boolean uniquenumberfound = true;

			int number = 0;

			while (uniquefullIDfound == false) {

				String numbertoadd = "";

				numbertoadd = Integer.toString(number);

				while (numbertoadd.length() < 4) {

					numbertoadd = "0" + numbertoadd;

				}

				fullID = shortID + numbertoadd;

				for (int j = 0; j < numberofIDscreated; j++) {

					if (fullID.equals(usedfullIDs[j])) {
						
						uniquenumberfound = false;

					}

				}

				if (uniquenumberfound == true) {

					uniquefullIDfound = true;

					usedfullIDs[numberofIDscreated] = fullID;

					numberofIDscreated++;

				}

				else {

					number++;

				}

			}

		}

		else {
			
			fullID = shortID + "0000";

			usedfullIDs[numberofIDscreated] = fullID;

			numberofIDscreated++;

		}

		return fullID;
		
		}
		
		else {
			
			return null;
			
		}
		
	}
		
	private String getInput() {

		Scanner inputscanner = new Scanner(System.in);

		String inputstring = inputscanner.nextLine();

		return inputstring.toLowerCase();

	}

}
