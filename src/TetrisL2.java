
/**
 * @author Rafay
 * 
 * 
 *         class TetrisL2 make steh L2 shape and is inherited from TetrisPiece
 *         class
 *
 */
public class TetrisL2 extends TetrisPiece {

	// makes the shape
	public boolean L2[][][] = {
			{ { false, true, false, false }, { false, true, false, false }, { true, true, false, false },
					{ false, false, false, false }, },
			{ { true, false, false, false }, { true, true, true, false }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { true, true, false, false }, { true, false, false, false }, { true, false, false, false },
					{ false, false, false, false }, },
			{ { false, false, true, false }, { true, true, true, false }, { false, false, false, false },
					{ false, false, false, false }, }, };

	// inheritance
	public TetrisL2() {
		super();
		filledSquares = L2;

	}

}
