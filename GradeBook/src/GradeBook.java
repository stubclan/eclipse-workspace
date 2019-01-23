import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeBook {
	
	static int totalNoOfStudents;
	static Map<String, String> studentGradeBook;
	static Map<String, Double> studentGradeBookAverage;
	static int[] numbers;
	

	public static void main(String[] args) {
		totalNoOfStudents = 0;
		studentGradeBook = new HashMap<String, String>();
		studentGradeBookAverage = new HashMap<String, Double>();
		
		getInput();

		setStudentGradeAverage();
		
		printGradeBook();		
		
	}
	
	/**
	 * A simple helper method to print Grade Book with average score
	 */	
	public static void printGradeBook() {
		studentGradeBookAverage.forEach((student, gradeAverage) -> 
		System.out.println("Student Name: " + student + "\tGrade Average: " + gradeAverage + "\n"));			
	}

	/**
	 * A method to add student name and their grade Average to studentGradeBookAverage Map<String, Double>
	 */
	public static void setStudentGradeAverage() {
		//One single line code to read every Key Value pair in Map 
		//Using Lambda expression

		studentGradeBook.forEach((student, stringGrades) ->
			studentGradeBookAverage.put(student, getAverage(stringGrades)));
	}
	
	/**
	 * A method to get User input
	 * This method gets student number, name and grades in String and saves to studentGradeBook Map<String, String>
	 */
	public static void getInput() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter total number of students (positive integer)");
		totalNoOfStudents = in.nextInt();
		String test = in.nextLine();
	
		for (int i = 1; i <= totalNoOfStudents; i++) {
			System.out.println("Enter students name: ");
			String studentName = in.nextLine();
			
			System.out.println("Enter students Grades (Positive Integer separated by comma): ");
			String studentGrades = in.nextLine();
			
			studentGradeBook.put(studentName, studentGrades);
 		}
	}
	
	/**
	 * A method to compute average grade from grade input as String
	 * @param studentGrades Numbers input as comma separated String
	 * @return average Average of comma separated numbers
	 */
	
	public static double getAverage(String studentGrades) {
		
		int sum = 0;		
		
		int[] gradeNumbers = convertIntoNumbers(studentGrades);
		
		for (int number : gradeNumbers) {
			sum += number;
		}

		double average = (double)sum / (double)gradeNumbers.length;
		
		System.out.println(average);

		return average;
	}
	
	/**
	 * Helper method for getAverage to convert String into number array
	 * @param inputNumbers Numbers input as comma separated String
	 * @return numbers Numbers array
	 */
	
	public static int[] convertIntoNumbers(String inputNumbers) {
		
		
		if (!(inputNumbers.equals("")) && !(inputNumbers.equals(null))) {
			String[] inputSplitArray = inputNumbers.split(",");

			numbers = new int[inputSplitArray.length];

			for (int i = 0; i < inputSplitArray.length; i++) {
				if (!(inputSplitArray[i].equals(""))) {
					int number = Integer.parseInt(inputSplitArray[i]);
					numbers[i] = number;
				}
			}
		}
		
		return numbers;
	}
}
