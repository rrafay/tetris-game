
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Rafay
 * 
 * 
 *         Class TetrisGameTextController class controls the text of Tetris
 *
 */
public class TetrisGameTextController {

	// instance variables
	private TetrisGame game;
	private TetrisBoardTextView view;

	// Constructor
	public TetrisGameTextController() {

	}

	// makes the grid
	public void boardGrid() {
		game = new TetrisGame();
		view = new TetrisBoardTextView(game.getTetrisBoard());
		readInput();

	}

	// analyze the letters that user inputs
	public void readInput() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			String l;
			// do..while loop
			do {
				System.out.println("Please enter a move (l,r,d,z,x) or type Quit to end.");
				l = in.readLine();
				game.attemptMove(moveEntered(l));
				refreshDisplay();

			} while (!l.equals("Quit"));

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// refresh Display
	private void refreshDisplay() {
		System.out.println("Tetrises cleared: " + game.getNumLines() + "\nLines cleared: " + game.getlinesCleared()
				+ "\n" + view.getBoardString());

	}

	// converts input: string type into int type
	private int moveEntered(String move) {
		int step = 0;
		if (move.equals("r")) {
			step = 1;
		}

		else if (move.equals("l")) {
			step = 5;

		}

		else if (move.equals("d")) {
			step = 4;

		}

		else if (move.equals("z")) {
			step = 2;

		}

		else if (move.equals("x")) {
			step = 3;

		}
		return step;
	}

}
