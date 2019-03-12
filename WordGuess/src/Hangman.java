import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	
	private String gameWord;
	private String guessWord;
	
	private int guessChances;
	private int maxChances;
	
	private ArrayList<Integer> guessWordIndexes;
	
	public Hangman() throws FileNotFoundException {
		//A method to look into the files and select a gameword for class
		this.gameWord = setThisGameWord();
		this.guessWordIndexes = new ArrayList<Integer>();
		this.guessChances = 0;
		this.maxChances = 5;
		
		this.guessWord = gameWord.replaceAll(".","-");
	}
	
	//Getters
	
	public String getGuessWord() {
		return this.guessWord;
	}
	
	public int getChancesLeft() {
		return this.maxChances - this.guessChances;
	}
	
	/**
	 * A method to check if the game is won
	 * @return true if the guessWord matches the gameWord; false if it doesn't
	 */
	public boolean isWin() {
		return (gameWord.equals(guessWord));
	}
	
	/**
	 * A method to check if the game is over
	 * @return true if either game is over no chances left
	 */
	public boolean isOver() throws Exception{
		return (isWin() || chancesLeft());
	}
	
	public void endGame() {	
		System.out.println("No more chances left. You lost!!");
		System.out.println("The correct word was "+ this.gameWord);
	}
	
	
	/**
	 * A method to check if the user is out of guess chances
	 * @return True if chances are over the limited amount; false if not
	 * @throws Exception 
	 */
	public boolean chancesLeft() throws Exception {
		if (this.guessChances > this.maxChances) throw new Exception("Too many chances");
		return (this.guessChances != this.maxChances);
	}
	
	
	/**
	 * Checks if the word containns the guessed letter
	 * Adds to the guess counter
	 * @param guessChar Guess letter
	 * @return true if the word has the letter; false if the letter is absent
	 */
	public void guessLetter(char guessChar) {
		
		this.guessChances ++;		

		if (this.gameWord.indexOf(guessChar)!= -1) {
			this.replace(guessChar);
			this.guessChances --;			

		}
		

		
	}
	
	/**
	 * A method to replace a the input letter if found in the Game Word
	 * Replaces the matched character and updates the guessWord
	 * @param guessChar Guess letter
	 */
	
	private void replace(char guessChar) {
		
		getIndexesOfChar(guessChar);
		
		char[] gameTestWord = gameWord.toCharArray();
		char[] guessTestWord = guessWord.toCharArray();
				
		for (int i: this.guessWordIndexes) {
			guessTestWord[i] = gameTestWord[i];
 		}
		
		this.guessWord = new String(guessTestWord);		
				
	}
	
	/**
	 * A method to add all the indexes for the characters to the main ArrayList
	 * @param guessChar letter to be guessed
	 */
	
	private void getIndexesOfChar(char guessChar) {
		
		ArrayList<Integer> charIndexes = new ArrayList<Integer>();
		int i = 0;
		
		for (char singleChar: gameWord.toCharArray()) {
			
			if (singleChar == guessChar) {
				charIndexes.add(i);				
			}
			i++;
		}
		
		for (int singleIndex: charIndexes) {
			this.guessWordIndexes.add(singleIndex);
		}
	}
	
	/**
	 * A private method for the game to randomly choose 
	 * @throws FileNotFoundException throws exception is the file is not found
	 */
	private String setThisGameWord() throws FileNotFoundException {
		ArrayList<String> wordsArray = new ArrayList<String>();		
		
		Scanner scanner = new Scanner(new File("words.txt"));		
		
		while (scanner.hasNextLine()) {
			wordsArray.add(scanner.nextLine());
		}
		
		Random random = new Random();		
		
		return wordsArray.get(random.nextInt(wordsArray.size()));
		

	}
	
	
}
