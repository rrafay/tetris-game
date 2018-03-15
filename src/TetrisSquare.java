
/**
 * @author Rafay
 *
 *         Tetris square class extends tetris piece class
 */
public class TetrisSquare extends TetrisPiece {

	// makes the shape
	public boolean box[][][] = {
			{ { true, true, false, false }, { true, true, false, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { true, true, false, false }, { true, true, false, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { true, true, false, false }, { true, true, false, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { true, true, false, false }, { true, true, false, false }, { false, false, false, false },
					{ false, false, false, false }, }, };

	// inheritance
	public TetrisSquare() {
		super();
		filledSquares = box;

	}

}
