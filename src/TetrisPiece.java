
/**
 * @author Rafay
 *
 *         Tetris Piece class
 */
public abstract class TetrisPiece {

	// Instance variables
	protected boolean[][][] filledSquares;
	protected int pieceRotation = 0;

	// Tetris Piece constructor
	public TetrisPiece() {

	}

	// rotate Clock Wise
	public int rotateCW() {
		return (pieceRotation + 1) % 4;

	}

	// rotate counter clockwise
	public int rotateCCW() {
		return (pieceRotation + 3) % 4;

	}

	// return rotation of the piece
	public int getPieceRotation() {
		return pieceRotation;
	}

	// create an array that holds the values of a piece
	public void arrayShape() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					filledSquares[i][j][j] = false;

				}

			}
		}

	}

}
