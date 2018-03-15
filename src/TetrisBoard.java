/**
 * @author Rafay
 *
 *         Tetris Board class
 */
public class TetrisBoard {

	// Instance variables for row and coloumn
	public static final int NUM_ROW = 18;
	public static final int NUM_COL = 10;

	private int numCols;
	private int numRows;

	// block matrix
	private boolean[][] blockMatrix = new boolean[NUM_ROW][NUM_COL];

	// creates an object piece
	public TetrisPiece currentPiece;
	// keep track of the piece on grid position
	private int[] currentPieceGridPosition;

	// constructor TetrisBoard, gets blockMatrix and makes a new piece
	public TetrisBoard() {
		getBlockMatrix();
		addNewPiece();
		initCurrentGP();

	}

	// BlockMatrix method
	public boolean[][] getBlockMatrix() {
		for (int i = 0; i < NUM_ROW; i++) {

			for (int j = 0; j < NUM_COL; j++) {
				blockMatrix[i][j] = false;
			}
		}
		return blockMatrix;
	}

	// init Board method
	public void initBoard(int[] location, TetrisPiece piece) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				blockMatrix[i + location[0]][j + location[1]] = piece.filledSquares[piece.pieceRotation][i][j];
			}
		}

	}

	// initCurrentGP method
	public void initCurrentGP() {
		currentPieceGridPosition = new int[2];
		currentPieceGridPosition[0] = 0;
		currentPieceGridPosition[1] = 3;

	}

	// add new piece method. generates shapes
	public void addNewPiece() {
		int piece;
		piece = (int) Math.floor(7 * Math.random());
		if (piece == 0) {
			currentPiece = new TetrisS1();
		} else if (piece == 1) {
			currentPiece = new TetrisL2();
		} else if (piece == 2) {
			currentPiece = new TetrisSquare();
		} else if (piece == 3) {
			currentPiece = new TetrisL1();
		} else if (piece == 4) {
			currentPiece = new TetrisStick();
		} else if (piece == 5) {
			currentPiece = new TetrisS2();
		} else {
			currentPiece = new TetrisL2();
		}
	}

	// land piece method. adds piece to board when it stops landing
	public void landPiece()

	{
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (currentPiece.filledSquares[currentPiece.pieceRotation][i][j]) {
					blockMatrix[i + currentPieceGridPosition[0]][j + currentPieceGridPosition[1]] = true;
					clearLine();
				}

			}
		}

	}

	// move left method. makes the piece move left
	public boolean moveLeft() {
		boolean left = false;
		int[] var = new int[] { currentPieceGridPosition[0], currentPieceGridPosition[1] - 1 };

		if (!detectOutOfBounds(currentPiece, var, currentPiece.pieceRotation)) {
			if (!detectCollision(currentPiece, var, currentPiece.pieceRotation)) {
				left = true;
				currentPieceGridPosition = var;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (currentPiece.filledSquares[currentPiece.pieceRotation][i][j]) {
							blockMatrix[0 + i][3 + j] = false;

						}
					}

				}
			}
		}
		return left;

	}

	// move right method. makes the piece move right
	public boolean moveRight() {
		boolean right = false;
		int[] var = new int[] { currentPieceGridPosition[0], currentPieceGridPosition[1] + 1 };

		if (!detectOutOfBounds(currentPiece, var, currentPiece.pieceRotation)) {
			if (!detectCollision(currentPiece, var, currentPiece.pieceRotation)) {
				right = true;
				currentPieceGridPosition = var;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (currentPiece.filledSquares[currentPiece.pieceRotation][i][j]) {
							blockMatrix[0 + i][3 + j] = false;
						}
					}

				}

			}
		}
		return right;
	}

	// move down method. makes the piece move down
	public boolean moveDown() {
		int[] var = new int[] { currentPieceGridPosition[0] + 1, currentPieceGridPosition[1] };
		boolean down = false;
		if (!detectOutOfBounds(currentPiece, var, currentPiece.pieceRotation)) {
			if (!detectCollision(currentPiece, var, currentPiece.pieceRotation)) {
				down = true;
				currentPieceGridPosition[0]++;

				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (currentPiece.filledSquares[currentPiece.pieceRotation][i][j]) {
							blockMatrix[0 + i][3 + j] = false;
						}
					}
				}
			}
		}

		return down;
	}

	// rotate counter clockwise 90 degrees
	public void rotateCW() {
		if (validMove(currentPiece.rotateCW(), currentPieceGridPosition, currentPiece)) {
			currentPiece.pieceRotation = currentPiece.rotateCW();
		}
	}

	// rotate counter clockwise
	public void rotateCCW() {
		if (validMove(currentPiece.rotateCCW(), currentPieceGridPosition, currentPiece)) {
			currentPiece.pieceRotation = currentPiece.rotateCCW();
		}
	}

	// check if the line is filled when landed
	public boolean fullLine(int row) {
		boolean full = true;
		for (int j = 0; j < NUM_COL; j++)
			if (!blockMatrix[row][j]) {
				full = false;
			}
		return full;
	}

	// clears the line when one line is filled. Also moves the board down
	public void clearLine() {
		for (int i = 0; i < NUM_ROW; i++) {
			if (fullLine(i)) {
				for (int j = 0; j < NUM_COL; j++) {
					blockMatrix[i][j] = false;
				}
				for (int f = i; f > 0; f--) {
					for (int g = 0; g < NUM_COL; g++)
						blockMatrix[f][g] = blockMatrix[f - 1][g];
				}
			}
		}
	}

	// Detect if the pieces collide
	public boolean detectCollision(TetrisPiece piece, int[] location, int rot) {
		boolean collision = false;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (piece.filledSquares[rot][i][j] && !detectOutOfBounds(piece, location, rot)) {
					if (blockMatrix[location[0] + i][location[1] + j]) {
						collision = true;
					} else {
						collision = false;
					}
				}
			}
		}

		return collision;
	}

	// detect if the pieces have gone out of the block
	public boolean detectOutOfBounds(TetrisPiece piece, int[] location, int rot) {
		boolean border = false;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (piece.filledSquares[rot][i][j]) {

					if (location[0] + i > 17 || location[1] + j > 9 || location[0] + i < 0 || location[1] + j < 0) {
						border = true;
					}

				}
			}
		}
		return border;
	}

	// Check if the move is valid
	public boolean validMove(int rot, int[] location, TetrisPiece piece) {
		boolean valid = false;
		if (!detectCollision(piece, location, rot) && !detectOutOfBounds(piece, location, rot)) {
			valid = true;
		}

		return valid;
	}

	// Check if there is a block in the row and column
	public boolean hasBlock(int row, int col) {

		int[] var = new int[] { currentPieceGridPosition[0], currentPieceGridPosition[1] };
		boolean val = false;
		if (blockMatrix[row][col] == true) {
			val = true;
		} else {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					if (currentPiece.filledSquares[currentPiece.pieceRotation][i][j]) {
						//
						if (i + var[0] == row) {
							if (j + var[1] == col) {
								val = true;

							}
						}
					}

				}
			}

		}

		return val;
	}

	// gets number of colums
	public int getNumCols() {
		return numCols;
	}

	// gets number of rows
	public int getNumRows() {
		return numRows;
	}

	// gets the current position of piece on grid
	public int[] getCurrentPieceGridPosition() {
		return currentPieceGridPosition;
	}

	// gets the current piece
	public TetrisPiece getCurrentPiece() {
		return currentPiece;
	}

}
