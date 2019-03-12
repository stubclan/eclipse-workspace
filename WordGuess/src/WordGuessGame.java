import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGuessGame {
	
	public static int MAGIC_NUMBER = 37099;
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Lets start a word guessing game.");
		
		Hangman hangman = new Hangman();	
		
		System.out.println("I've picked a random word from English dictionary with "+ hangman.getGuessWord().length() + "letters.");
		System.out.println("Please enter letters a-z");
		
		Scanner in = new Scanner(System.in);
		hangman.endGame();
		while (!(hangman.isWin())) {
			if (hangman.chancesLeft()) {
				System.out.println("Chances Left: " + hangman.getChancesLeft());
				System.out.println(hangman.getGuessWord());
				char guessChar = in.nextLine().charAt(0);	
				hangman.guessLetter(guessChar);
			}
			else {
				hangman.endGame();
				break;
			}
			
		}
		
		if (hangman.isWin()) {
			System.out.println("Congratutlations you've guessed the word correctly." + hangman.getGuessWord());
		}
		
	}
}