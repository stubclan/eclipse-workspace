import java.util.Scanner;

public class Statistics {

	private static int min;
	private static int max;
	private static double average;
	private static int sum;
	private static int numberOfElements;

	private static int[] numbers;

	public static void main(String[] args) {

		// initialization
		min = 0;
		max = 0;
		sum = 0;
		numberOfElements = 0;

		average = 0;

		if (getInput()) {
			calculateSum();
			System.out.println("The minimum of all numbers is: " + getMin());
			System.out.println("The maximum of all numbers is: " + getMax());
			System.out.println("The sum of all numbers is: " + getSum());
			System.out.println("The total number of elements is: " + getNumberOfElements());
			System.out.println("The average of all numbers is: " + getAverage());
		}

	}

	public static boolean getInput() {
		Scanner in = new Scanner(System.in);

		System.out.println("Input your number/s(only positive integers, comma for multiple)");

		String inputNumbers = in.nextLine();
		if (!(inputNumbers.equals("")) && !(inputNumbers.equals(null))) {
			String[] inputSplitArray = inputNumbers.split(",");

			numbers = new int[inputSplitArray.length];

			for (int i = 0; i < inputSplitArray.length; i++) {
				numbers[i] = Integer.parseInt(inputSplitArray[i]);
			}
			return true;
		}
		return false;
	}

	public static int getMin() {
		if (getNumberOfElements() == 0) {
			min = 0;
		} else if (getNumberOfElements() == 1) {
			min = numbers[0];
		} else {
			min = numbers[0];
			for (int number : numbers) {
				if (number < min) {
					min = number;
				}
			}
		}

		return min;
	}

	public static int getMax() {

		if (getNumberOfElements() == 0) {
			max = 0;
		} else if (getNumberOfElements() == 1) {
			max = numbers[0];
		} else {
			max = Integer.MIN_VALUE;
			for (int number : numbers) {
				if (number > max) {
					max = number;
				}
			}
		}

		return max;
	}

	public static double getAverage() {
		
		average = (double)sum / getNumberOfElements();

		return average;
	}

	public static void calculateSum() {
		for (int number : numbers) {
			sum += number;
		}
	}
	
	public static int getSum() {
		return sum;
	}

	public static int getNumberOfElements() {
		numberOfElements = numbers.length;
		return numberOfElements;
	}

	public static int[] getNumbers() {
		return numbers;
	}

}
