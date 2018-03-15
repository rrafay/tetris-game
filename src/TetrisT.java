
/**
 * @author Rafay
 *
 *
 *         class TetrisT makes the T shape and is inherited from TetrisPiece
 *         class
 */
public class TetrisT extends TetrisPiece {

	// makes the shape
	public boolean T[][][] = {
			{ { false, true, false, false }, { true, true, true, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { false, true, false, false }, { false, true, true, false }, { false, true, false, false },
					{ false, false, false, false }, },
			{ { true, true, true, false }, { false, true, false, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { false, true, false, false }, { true, true, false, false }, { false, true, false, false },
					{ false, false, false, false }, }, };

	// inheritance
	public TetrisT() {
		super();
		filledSquares = T;

	}

}
