import java.util.Scanner;

/**
 * A program to play Tic-Tac-Toe game.
 * 
 * @author Sujan Aryal
 *
 */
public class TicTacToe {
	// Variables
	public static int ROWS = 3;
	public static int COLUMNS = 3;
	public static char[][] board;

	// Tile markings
	public static final char PLAYER_ONE_TILE = 'X';
	public static final char PLAYER_TWO_TILE = 'O';
	public static final char UNINITIALIZED_TILE = ' ';

	// Game states
	public static final int IN_PROGRESS = 0;
	public static final int PLAYER_ONE_WINS = 1;
	public static final int PLAYER_TWO_WINS = 2;
	public static final int DRAW = 3;

	public static void main(String[] args) {

		board = new char[ROWS][COLUMNS];
		initBoard();
		printBoard();

		while (!isFinished()) {
			move();
		}

		printResult();

	}

	public static void printResult() {
		if (isWinner(board, PLAYER_ONE_TILE)) {
			System.out.println("Player One(X) Wins");
		} else if (isWinner(board, PLAYER_TWO_TILE)) {
			System.out.println("Player Two(Y) Wins");
		} else {
			System.out.println("Game of Draw");
		}		
	}

	public static void initBoard() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				board[i][j] = UNINITIALIZED_TILE;
			}
		}
	}

	public static void printBoard() {
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				System.out.print(board[row][column]);

				if (column < 2) {
					System.out.print("  |  ");
				}
			}
			System.out.println();
			if (row < 2) {
				System.out.println("___|_____|____");
			}
		}
		System.out.println("   |     |  ");
	}

	public static void move() {
		Scanner in = new Scanner(System.in);
		if (!isFinished()) {
			System.out.println("Player 1's(X) move.");
			System.out.println("Please enter row (0-2)");
			int xRow = in.nextInt();
			System.out.println("Please enter column(0,2)1");
			int xColumn = in.nextInt();
			processMove(PLAYER_ONE_TILE, xRow, xColumn);

			printBoard();
		
			System.out.println("Player 2's(O) move");
			System.out.println("Please enter row");
			int row = in.nextInt();
			System.out.println("Please enter column");
			int column = in.nextInt();
			processMove(PLAYER_TWO_TILE, row, column);

			printBoard();
		}
	}

	// Private method to put 'X' or 'O'
	private static void processMove(char mark, int row, int column) {

		if (board[row][column] == UNINITIALIZED_TILE) {
			board[row][column] = mark;
		}
	}

	public static boolean isFinished() {
		return getGameState(board) != IN_PROGRESS;
	}

	public static boolean isWinner(char[][] board, char mark) {
		if (isDiagonalFinished(board, mark)) {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			if (isRowFinished(board, i, mark) || isColumnFinished(board, i, mark)) {
				return true;
			}
		}

		return false;
	}

	public static int getGameState(char[][] board) {
		if (isWinner(board, PLAYER_ONE_TILE)) {
			return PLAYER_ONE_WINS;
		} else if (isWinner(board, PLAYER_TWO_TILE)) {
			return PLAYER_TWO_WINS;
		} else if (isDraw(board)) {
			return DRAW;
		} else {
			return IN_PROGRESS;
		}
	}

	// Checks if the game is draw or not.
	public static boolean isDraw(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == UNINITIALIZED_TILE) {
					return false;
				}
			}
		}
		return true;
	}

	// Checks if the row is finished.
	public static boolean isRowFinished(char[][] board, int row, char mark) {
		return marksInRow(board, row, mark) == 3;
	}

	// Checks if the column is finished.
	public static boolean isColumnFinished(char[][] board, int column, char mark) {
		return marksInColumn(board, column, mark) == 3;
	}

	// Checks if the diagonals is finished.
	public static boolean isDiagonalFinished(char[][] board, char mark) {
		return marksInDiagonal(board, mark) == 3 || marksInDiagonaRightToLeft(board, mark) == 3;
	}

	// Checks the marks in rows of the board.
	public static int marksInRow(char[][] board, int row, char mark) {
		int count = 0;
		for (int column = 0; column < COLUMNS; column++) {
			if (board[row][column] == mark) {
				count++;
			}
		}
		return count;
	}

	// Checks the marks in Column of the board.
	public static int marksInColumn(char[][] board, int column, char mark) {
		int count = 0;
		for (int row = 0; row < ROWS; row++) {
			if (board[row][column] == mark) {
				count++;
			}
		}
		return count;
	}

	// Checks the marks in Leading Diagonal of the board.
	public static int marksInDiagonal(char[][] board, char mark) {
		int count = 0;
		for (int row = 0, column = 0; row < ROWS; row++, column++) {
			if (board[row][column] == mark) {
				count++;
			}
		}
		return count;
	}

	// Checks the marks in Counter Diagonal of the board.
	public static int marksInDiagonaRightToLeft(char[][] board, char mark) {
		int count = 0;
		for (int row = 0, column = 2; row < ROWS; row++, column--) {
			if (board[row][column] == mark) {
				count++;
			}
		}
		return count;
	}

}
