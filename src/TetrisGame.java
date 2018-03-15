
/**
 * @author Rafay
 * 
 *         Tetris Game class
 */
public class TetrisGame {

	// Instance Variables
	public static final int RIGHT = 1;
	public static final int LEFT = 5;
	public static final int DOWN = 4;
	public static final int CCW = 2;
	public static final int CW = 3;

	private int numLines;
	private int numTetrises = numLines * 10;
	private TetrisBoard tetrisBoard;

	// constructor
	public TetrisGame() {
		tetrisBoard = new TetrisBoard();
	}

	// Moves the curent piece up down, left, right, ccw, and cw
	public void attemptMove(int moveType) {

		if (moveType == 5) {
			tetrisBoard.moveLeft();
		}

		else if (moveType == 2) {
			tetrisBoard.rotateCW();

		}

		else if (moveType == 3) {

			tetrisBoard.rotateCW();
		}

		else if (moveType == 4) {
			if (!tetrisBoard.moveDown()) {

				for (int i = 0; i < TetrisBoard.NUM_ROW; i++) {

					if (tetrisBoard.fullLine(i)) {

						numLines++;

						System.out.println(numLines);
					}
				}

				tetrisBoard.landPiece();
				tetrisBoard.addNewPiece();
				tetrisBoard.initCurrentGP();

			}

		}

		else if (moveType == 1) {
			tetrisBoard.moveRight();
		}
	}

	// return numLines
	public int getNumLines() {
		return numLines;
	}

	// return nunTetrises
	public int getNumTetrises() {
		return numTetrises;
	}

	// return tetris board
	public TetrisBoard getTetrisBoard() {
		return tetrisBoard;
	}

	// clears the lines
	public int getlinesCleared() {
		return numLines;
	}

}
