/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		boolean test=false;
		while (test == false) {
			System.out.println("Please enter values you want calculated.");
			String input = userInput.nextLine();
			System.out.println(produceAnswer(input));
			System.out.println("Type \"quit\" if you want to end.");
			if (userInput.nextLine() == "quit") {
				test = true;
			}
		}
		userInput.close();
	}
	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
	// This function takes a String 'input' and produces the result
	public static String produceAnswer(String input){ 
		String[] array = input.split(" ");
		String firstOperand = array[0];
		String operator = array[1];
		String secondOperand = array[2];
		firstOperand = toImproperFracString(firstOperand);
		secondOperand = toImproperFracString(secondOperand);
		String[] firstOpSplit = firstOperand.split("/");
		String[] secondOpSplit = secondOperand.split("/");
		int firstNumerator = Integer.parseInt(firstOpSplit[0]);
		int firstDenominator = Integer.parseInt(firstOpSplit[1]);
		int secondNumerator = Integer.parseInt(secondOpSplit[0]);
		int secondDenominator = Integer.parseInt(secondOpSplit[1]);
		int commonDenominator = Math.abs(firstDenominator * secondDenominator);
		int wholeNumber = 0;
		firstNumerator *= secondDenominator;
		secondNumerator *= firstDenominator;
		if (operator.equals("+")) {
			firstNumerator += secondNumerator;
		}
		if (operator.equals("-")) {
			firstNumerator -= secondNumerator;
		}
		if (operator.equals("*")) {
			firstNumerator *= secondNumerator;
			commonDenominator *= commonDenominator;
		}
		if (operator.equals("/")) {
			firstNumerator *= commonDenominator;
			commonDenominator *= secondNumerator;
		}
		while( firstNumerator % 2 == 0 && commonDenominator % 2 == 0)
		{
			firstNumerator /= 2;
			commonDenominator /= 2;
		}
		while( firstNumerator % commonDenominator == 0) 
		{
			wholeNumber = firstNumerator / commonDenominator;
			return (wholeNumber+"");
		}
		if(Math.abs(firstNumerator) % commonDenominator >= 1 ) {
			wholeNumber = firstNumerator / commonDenominator;
			firstNumerator -= (wholeNumber*commonDenominator);
			int gcf = gcf(Math.abs(firstNumerator) ,Math.abs(commonDenominator));
			commonDenominator = commonDenominator / gcf;
			firstNumerator = firstNumerator / gcf;
			if(wholeNumber == 0) {
				if(commonDenominator < 0) {
					return("-" + firstNumerator + "/" + Math.abs(commonDenominator));
				}
				return(firstNumerator + "/" + Math.abs(commonDenominator));
			}
			return (wholeNumber + "_" + Math.abs(firstNumerator) + "/" + Math.abs(commonDenominator));
		}
		return(firstNumerator + "/" + Math.abs(commonDenominator));
	}
	public static String toImproperFracString(String input) {
		int numerator = 0;
		int denominator = 1;
		int wholeNum = 0;
		int improperNumerator = 0;
		String[] mixednumbersplit = input.split("_");
		String stringWholeNum = mixednumbersplit[0];
		if(mixednumbersplit.length == 2) {
			String fraction = mixednumbersplit[1];
			String[] fractionsplit = fraction.split("/");
			String stringNumerator = fractionsplit[0];
			String stringDenominator = fractionsplit[1];
			wholeNum = Integer.parseInt(stringWholeNum);
			numerator = Integer.parseInt(stringNumerator);
			denominator = Integer.parseInt(stringDenominator);
			if(wholeNum < 0) {
				improperNumerator = wholeNum*denominator - numerator;
			}
			if(wholeNum >= 0) {
				improperNumerator = wholeNum * denominator + numerator;
			}
			return (improperNumerator + "/" + denominator);
		}
		else {
			String fraction = mixednumbersplit[0];
			String[] fractionsplit = fraction.split("/");
			if (fractionsplit.length == 2){
				String stringNumerator = fractionsplit[0];
				String stringDenominator = fractionsplit[1];
				numerator = Integer.parseInt(stringNumerator);
				denominator = Integer.parseInt(stringDenominator);
				improperNumerator = numerator;
				return (improperNumerator + "/" + denominator);
			}
			if(fractionsplit.length == 1) {
				wholeNum= Integer.parseInt(stringWholeNum);
				return (Integer.toString(wholeNum) + "/" + denominator);
			}
		}
		return ("error");
	}
	// finds the greatest common factor
	public static int gcf(int num1, int num2) {
		int answer = 1;
		for (int i = min(num1,num2); i > 0; i --) {
			if (max(num1, num2) % i == 0 && min(num1,num2) % i == 0) {
				if (i >= answer) {
					answer = i;
				}
			}
		}
		return answer;
	}
	// returns the minimum number
	public static int min(int num1, int num2) {
		if (num1 < num2) {
			return num1;
		}
		else {
			return num2;
		}
	}
	//returns the max number
	public static double max(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		}	
		else {
			return num2;
		}
	}
}