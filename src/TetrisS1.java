
/**
 * @author Rafay
 * 
 *         class TetrisS1 makes the S1 shape and is inherited from TetrisPiece
 *         class
 *
 */
public class TetrisS1 extends TetrisPiece {

	// makes the shape
	public boolean S1[][][] = {
			{ { false, true, true, false }, { true, true, false, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { true, false, false, false }, { true, true, false, false }, { false, true, false, false },
					{ false, false, false, false }, },
			{ { false, true, true, false }, { true, true, false, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { true, false, false, false }, { true, true, false, false }, { false, true, false, false },
					{ false, false, false, false }, }, };

	// inheritance
	public TetrisS1() {
		super();
		filledSquares = S1;

	}

}
