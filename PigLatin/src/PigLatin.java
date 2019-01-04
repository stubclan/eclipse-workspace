import java.util.Scanner;

public class PigLatin {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Input an English word");
		String input = in.next();
		
		System.out.println(translateToPigLatin(input));
		
		in.close();
		
	}
	
	public static String translateToPigLatin(String input) {
		
		CharSequence vowel = "a, e, i, o, u";
		
		char firstChar = input.charAt(0);
		if (checkIfVowel(Character.toLowerCase(firstChar))) {
			return (input + "yay");
		}
		else if (!checkIfVowel(Character.toLowerCase(firstChar))) {
			int vowelIndex = getIndexOfVowel(input);
			System.out.println(vowelIndex);
			return (input.substring(vowelIndex, input.length()) + input.substring(0, vowelIndex));
		}
		else {
			return (input + "ay");
		}
		
	}
	
	public static int getIndexOfVowel(String input) {
		String vowels = "a, e, i, o, u";
		
		char[] vowelArray = vowels.toCharArray();
		for (char vowel: vowelArray) {
			return input.indexOf(vowel);
		}
		return 0;
	}

	public static boolean checkIfVowel(char firstChar) {
		if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
			return true;
		}
		return false;
	}

}
