import java.util.Scanner;

/**
 * @author Sujan_Aryal
 * @description A calculator class
 */
public class Calculator {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		

		System.out.println("Insert First Number");
		int firstNumber = input.nextInt();
		
		System.out.println("Insert Second Number");
		int secondNumber = input.nextInt();
		
		System.out.println("Insert Operator (+,-,/,*)");
		char operator = input.next().charAt(0);	
		
		switch (operator) {
		case '+':
			System.out.println(add(firstNumber, secondNumber));
			break;
		case '-':
			System.out.println(subtract(firstNumber, secondNumber));
			break;
		case '/':
			System.out.println(divide(firstNumber, secondNumber));
			break;
		case '*':
			System.out.println(subtract(firstNumber, secondNumber));
			break;
		case '%':
			System.out.println(modulus(firstNumber, secondNumber));
			break;
			
		default:
			System.out.println("Invalid operator");
			break;
		}
		
		input.close();	
		
	}
	
	
	/**
	 * @param firstNumber First number to add
	 * @param secondNumber Second number to add
	 * @return sum Sum of two numbers
	 */
	public static int add(int firstNumber, int secondNumber) {
		int sum = firstNumber + secondNumber;
		return sum;
	}
	
	/**
	 * @param firstNumber First number to subtract from
	 * @param secondNumber Second number to subtract to
	 * @return difference Difference between number and two
	 */
	public static int subtract(int firstNumber, int secondNumber) {
		int difference = firstNumber - secondNumber;
		return difference;
	}
	
	/**
	 * @param firstNumber First number to multiply
	 * @param secondNumber Second number to multiply
	 * @return multipliedNumber Multiplied first and second number
	 */
	public static int multiply(int firstNumber, int secondNumber) {
		int multipliedNumber = firstNumber * secondNumber;
		return multipliedNumber;
	}
	
	/**
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	public static int divide(int firstNumber, int secondNumber) {
		int dividedNumber = firstNumber / secondNumber;
		return dividedNumber;
	}
	
	/**
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	public static int modulus(int firstNumber, int secondNumber) {
		int modulo = firstNumber % secondNumber;
		return modulo;
	}
	
	
	
}
