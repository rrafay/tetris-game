import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;

/**
 * @author Rafay
 * 
 *         TetrisBoard GUI View class. Includes a constructor, paint method for
 *         the background and the block, a method which computes teh size of the
 *         block and a setTetrisBoard method.
 *
 */
public class TetrisBoardGUIView extends JComponent {
	// instance variable for JPanel
	private JPanel mainPanel;
	// Import TetrisBoard class
	private TetrisBoard board;

	// constructor
	public TetrisBoardGUIView() {

		super.setLayout(new BorderLayout());
		repaint();
		mainPanel = new JPanel();
		add(mainPanel, BorderLayout.CENTER);

	}

	// Paint Method: this method gets the game dimensions from the main class
	public void paint(Graphics g) {

		// draw background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, TetrisGameGUIApplication.WIDTH, TetrisGameGUIApplication.HEIGHT);

		g.setColor(Color.BLACK);
		g.drawRect(0, 0, TetrisGameGUIApplication.WIDTH, TetrisGameGUIApplication.HEIGHT);
		int block = computeBlockSize(TetrisGameGUIApplication.WIDTH);

		paintBlock(g, block);

	}

	// paintBlock method paints the block
	private void paintBlock(Graphics g, int blockSize) {

		for (int i = 0; i < TetrisBoard.NUM_ROW; i++) {
			for (int j = 0; j < TetrisBoard.NUM_COL; j++) {
				if (board.hasBlock(i, j)) {

					g.setColor(Color.ORANGE);
					g.fillRect(j * blockSize, i * blockSize, blockSize, blockSize);

					g.setColor(Color.RED);
					g.drawRect(j * blockSize, i * blockSize, blockSize, blockSize);
				}

			}

		}
	}

	// Compute Block Size Method
	private int computeBlockSize(int width) {
		return width / board.NUM_COL;
	}

	// set the tetris board
	public void setTetrisBoard(TetrisBoard b) {
		board = b;
	}

}
