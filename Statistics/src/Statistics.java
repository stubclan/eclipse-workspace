import java.util.Scanner;

public class Statistics {
	
	private static int min;
	private static int max;
	private static int average;
	private static int sum;
	private static int numberOfElements;
	
	private static int[] numbers;
	
	public static void main(String[] args) {		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Input your number/s");
		
		String inputNumbers = in.nextLine();
		
		String[] inputSplitArray = inputNumbers.split(",");
		
		numbers = new int[inputSplitArray.length];
		
		for(int i = 0; i < inputSplitArray.length; i++) {
			 numbers[i] = Integer.parseInt(inputSplitArray[i]);
			 System.out.println(numbers[i]);
		}		
		
	}
	
	public static void getInput() {
		
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getAverage() {
		return average;
	}

	public int getSum() {
		return sum;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public int[] getNumbers() {
		return numbers;
	}
	
	

}
