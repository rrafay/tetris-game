/**
 * @author Rafay
 *
 *         Tetris board text view class
 */
public class TetrisBoardTextView {

	// Instance variable for class TetrisBoard
	TetrisBoard board;

	// constructor which takes in board and getBoardString method
	public TetrisBoardTextView(TetrisBoard b) {
		board = b;
		System.out.println(getBoardString());
	}

	// get board string method: prints things on board
	public String getBoardString() {
		String upper = "----------\n";
		String lower = "----------";
		String empty = "";

		for (int i = 0; i < TetrisBoard.NUM_ROW; i++) {
			empty = empty + "";
			for (int j = 0; j < TetrisBoard.NUM_COL; j++) {
				if (board.hasBlock(i, j))
					empty = empty + "x";
				else
					empty = empty + " ";
			}
			empty = empty + "\n";
		}
		return upper + empty + lower;
	}

}
