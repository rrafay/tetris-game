
/**
 * @author Rafay
 * 
 *         class TetrisL1 makes the L1 piece and inherits from TetrisPiece class
 *
 */
public class TetrisL1 extends TetrisPiece {

	// makes the shape
	public boolean L1[][][] = {
			{ { true, false, false, false }, { true, false, false, false }, { true, true, false, false },
					{ false, false, false, false }, },
			{ { true, true, true, false }, { true, false, false, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { true, true, false, false }, { false, true, false, false }, { false, true, false, false },
					{ false, false, false, false }, },
			{ { false, false, true, false }, { true, true, true, false }, { false, false, false, false },
					{ false, false, false, false }, }, };

	// inherit
	public TetrisL1() {

		super();
		filledSquares = L1;
	}

}
