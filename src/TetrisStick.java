
/**
 * @author Rafay
 *
 *
 *         class TetrisStick makes the stick shape and is inherited from
 *         TetrisPiece class
 */
public class TetrisStick extends TetrisPiece {

	// makes the shape
	public boolean stick[][][] = {
			{ { false, true, false, false }, { false, true, false, false }, { false, true, false, false },
					{ false, true, false, false }, },
			{ { false, false, false, false }, { true, true, true, true }, { false, false, false, false },
					{ false, false, false, false }, },
			{ { false, true, false, false }, { false, true, false, false }, { false, true, false, false },
					{ false, true, false, false }, },
			{ { false, false, false, false }, { true, true, true, true }, { false, false, false, false },
					{ false, false, false, false }, }, };

	// inheritance
	public TetrisStick() {
		super();
		filledSquares = stick;

	}

}
