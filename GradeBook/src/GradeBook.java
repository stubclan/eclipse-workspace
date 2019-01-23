import java.util.HashMap;
import java.util.Scanner;

public class GradeBook {
	
	static int totalNoOfStudents;
	

	public static void main(String[] args) {
		totalNoOfStudents = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter total number of students");
		totalNoOfStudents = in.nextInt();
		
		HashMap<String, String> studentGradeBook = new HashMap<String, String>();
	
		for (int i = 0; i < totalNoOfStudents; i++) {
			System.out.println("Enter students name: ");
			String studentName = in.nextLine();
			
			System.out.println("Enter students Grades (separated by comma): ");
			String studentGrades = in.nextLine();
			
			studentGradeBook.put(studentName, studentGrades);
 		}
		
	}
	
	public static double getAverage(int numbers) {
		
		int sum = 0;
		
		for (int number : numbers) {
			sum += number;
		}
		

		int average = getSum() / getNumberOfElements();

		return average;
	}

	public static int getSum(int numbers) {
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

}
