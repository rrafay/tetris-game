
/**
 * @author Rafay
 *
 *
 *
 *         class TetrisS2 makes the S2 shape and is inherited from TetrisPiece
 *         class
 */
public class TetrisS2 extends TetrisPiece {

	// makes the shape
	public boolean S2[][][] = {
			{ { true, true, false, false }, { false, true, true, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { false, true, false, false }, { true, true, false, false }, { true, false, false, false },
					{ false, false, false, false }, },
			{ { true, true, false, false }, { false, true, true, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { false, true, false, false }, { true, true, false, false }, { true, false, false, false },
					{ false, false, false, false }, }, };

	// inheritance
	public TetrisS2() {
		super();
		filledSquares = S2;
	}

}
