/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {
	static String w1s = "";
	static String n1s = "";
	static String d1s = "";

	static String w2s = "";
	static String n2s = "";
	static String d2s = "";

	static String f2 = "";
	static String f1 = "";
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
		String valOfProcessedFrac = processFractions(input);
		return valOfProcessedFrac;
	}

	public static String processFractions(String input) {
		f1 = input.substring(0, input.indexOf(" "));
		System.out.println("fraction1: " + f1);
		operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
		System.out.println("operator: " + operator);
		f2 = input.substring(input.indexOf(" ") + 3);
		System.out.println("fraction2: " + f2);
		w1s = f1;
		n1s = "0";
		d1s = "1";
		if (f1.indexOf("/") != -1) {
			if (f1.indexOf("_") != -1) {
				f1.substring(0, input.indexOf("_"));
			} else {
				w1s = "0";
			}
			n1s = f1.substring(f1.indexOf("_") + 1, f1.indexOf("/"));
			d1s = f1.substring(f1.indexOf("/") + 1, f1.length());

		}
		w2s = f2;
		n2s = "0";
		d2s = "1";
		if (f2.indexOf("/") != -1) {
			if (f2.indexOf("_") != -1) {
				w2s = f2.substring(0, f2.indexOf("_"));
			} else {
				w2s = "0";
			}
			n2s = f2.substring(f2.indexOf("_") + 1, f2.indexOf("/"));
			d2s = f2.substring(f2.indexOf("/") + 1, f2.length());
		}
		int n2 = Integer.parseInt(n2s);
		int d2 = Integer.parseInt(d2s);
		int w2 = Integer.parseInt(w2s);
		String returnThis = "whole:" + w2 + " numerator:" + n2 + " denominator:" + d2;
		return returnThis;

	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
