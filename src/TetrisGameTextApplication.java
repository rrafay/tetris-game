
/**
 * @author Rafay
 *
 *         Tetris Game Text Application class contains main method
 */
public class TetrisGameTextApplication {
	// inst variable to import TetrisGameTextController class
	private static TetrisGameTextController c;

	// Main method calls the TetrisGameTextController class and boardGrid within
	// that class
	public static void main(String[] args) {
		c = new TetrisGameTextController();
		c.boardGrid();

	}
}
