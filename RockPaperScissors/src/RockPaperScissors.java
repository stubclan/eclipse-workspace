import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Rock/Paper/Scissors");
		String input = in.next();
		
		String aiInput = getAiInput();
		
		System.out.println("You chose " + input + "| I chose " + aiInput);
		
		String winner = getWinner(input.toUpperCase(), aiInput.toUpperCase());
		
		System.out.println(winner + " " + input + " " + aiInput);
		System.out.println();
		
		if (winner.equals(input.toUpperCase())) {
			System.out.println("You win!");
		}
		else if (winner.equals(aiInput.toUpperCase())){
			System.out.println("I win!");
		}
		else {
			System.out.println("No one wins!");
		}
	}

	public static String getWinner(String input, String aiInput) {
		if ((input.equals("ROCK") || aiInput.equals("ROCK")) && (input.equals("PAPER") || aiInput.equals("PAPER"))) {
			return "PAPER";
		}
		else if ((input.equals("ROCK") || aiInput.equals("ROCK")) && (input.equals("SCISSORS") || aiInput.equals("SCISSORS"))) {
			return "ROCK";
		}
		else if ((input.equals("PAPER") || aiInput.equals("PAPER")) && (input.equals("SCISSORS") || aiInput.equals("SCISSORS"))) {
			return "SCISSORS";
		}
		else {
			return "NONE";
		}

	}

	public static String getAiInput() {
		String[] gameChoices = {"ROCK", "PAPER", "SCISSORS"};
		Random randNumGenerator = new Random();
	    int randNum = randNumGenerator.nextInt(3);
	    
	    return gameChoices[randNum];
	    
	}
	
	

}
