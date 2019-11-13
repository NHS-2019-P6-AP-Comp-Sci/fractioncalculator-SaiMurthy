/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {
	static String whole1s = "";
	static String numerator1s = "";
	static String denominator1s = "";

	static String whole2s = "";
	static String numerator2s = "";
	static String denominator2s = "";

	static String fraction2 = "";
	static String fraction1 = "";
	static String operator = "";

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		System.out.println("Welcome to fraction calculator");
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a expression or type \"quit\" to escape");
		String equation = console.nextLine();
		if (equation.equals("quit")) {
			System.out.println("Thanks for using fraction calculator");
			System.out.println("Goodbye!");
		}
		while (!equation.equals("quit")) {
			System.out.println(produceAnswer(equation));
			System.out.println();
			System.out.println("Enter a expression or type \"quit\" to escape");
			equation = console.nextLine();
		}

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		fraction2 = processFractions(input);
		return fraction2;
	}

	public static String processFractions(String input) {
		fraction1 = input.substring(0, input.indexOf(" "));
		System.out.println("fraction1: " + fraction1);
		operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
		System.out.println("operator: " + operator);
		fraction2 = input.substring(input.indexOf(" ") + 3);
		System.out.println("fraction2: " + fraction2);
		whole1s = fraction1;
		numerator1s = "0";
		denominator1s = "1";
		if (fraction1.indexOf("/") != -1) {
			if (fraction1.indexOf("_") != -1) {
				fraction1.substring(0, input.indexOf("_"));
			} else {
				whole1s = "0";
			}
			numerator1s = fraction1.substring(fraction1.indexOf("_") + 1, fraction1.indexOf("/"));
			denominator1s = fraction1.substring(fraction1.indexOf("/") + 1, fraction1.length());

		}
		whole2s = fraction2;
		numerator2s = "0";
		denominator2s = "1";
		if (fraction2.indexOf("/") != -1) {
			if (fraction2.indexOf("_") != -1) {
				whole2s = fraction2.substring(0, fraction2.indexOf("_"));
			} else {
				whole2s = "0";
			}
			numerator2s = fraction2.substring(fraction2.indexOf("_") + 1, fraction2.indexOf("/"));
			denominator2s = fraction2.substring(fraction2.indexOf("/") + 1, fraction2.length());
		}
		int numerator2 = Integer.parseInt(numerator2s);
		return fraction2;

	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
