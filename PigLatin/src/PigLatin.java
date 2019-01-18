import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Input an English Sentence");
		String word = in.next();

		System.out.println(translateToPigLatin(word));
		in.close();

	}

	public static String translateToPigLatin(String word) {

		char firstChar = Character.toLowerCase(word.charAt(0));

		if (checkIfVowel(firstChar)) {
			return (word + "yay");
		} else if (!(checkIfVowel(firstChar)) && checkIfStringHasVowel(word.toCharArray())) {
			int vowelIndex = getIndexOfFirstVowel(word);
			return (word.substring(vowelIndex, word.length()) + word.substring(0, vowelIndex) + "ay");
		} else {
			return (word + "ay");
		}

	}

	public static int getIndexOfFirstVowel(String input) {

		int[] indexArray = new int[45]; // Fact: The biggest word in English language is 45 characters long.
		int count = 0;

		for (int i = 0; i < indexArray.length; i++) {
			indexArray[i] = Integer.MAX_VALUE;
		}

		for (char single : input.toLowerCase().toCharArray()) {
			if (single == 'a' || single == 'e' || single == 'i' || single == 'o' || single == 'u') {
				indexArray[count] = input.indexOf(single);
				count++;
			}

		}

		return getSmallestIndex(indexArray);
	}

	public static int getSmallestIndex(int[] indexArray) {
		if (indexArray.length == 0)
			return -1;
		int smallest = indexArray[0];
		int index = 0;
		for (int i = 0; i < indexArray.length; i++) {
			if (indexArray[i] < smallest) {
				smallest = indexArray[i];
				index = i;
			}
		}

		return smallest;
	}

	public static boolean checkIfVowel(char firstChar) {
		if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
			return true;
		}
		return false;
	}

	public static boolean checkIfStringHasVowel(char[] charArray) {

		for (char firstChar : charArray) {
			if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u'
					|| firstChar == 'A' || firstChar == 'E' || firstChar == 'I' || firstChar == 'O'
					|| firstChar == 'U') {
				return true;
			}

		}
		return false;

	}

}
