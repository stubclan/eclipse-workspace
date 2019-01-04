package test;

public class Main {
	
	public static void main(String[] args) {
		System.out.println(getFibonacchiNumberAtPosition(32));
	}
	

	public static int getFibonacchiNumberAtPosition(int index) {
		
		if (index == 0) {
			return 1;
		}
		else if (index == 1) {
			return 1;
		}
		else 
		{
			return (getFibonacchiNumberAtPosition(index - 2) + getFibonacchiNumberAtPosition(index - 1)); 
		}			
		
	}

}