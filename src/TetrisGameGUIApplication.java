import javax.swing.JFrame;

/**
 * @author Rafay
 * 
 *         GUI Application class. Includes the main method and instance
 *         variables for the size of the screen
 *
 */
public class TetrisGameGUIApplication {

	// instance variables for screen size
	public static final int WIDTH = 380;
	public static final int HEIGHT = 800;

	// Constructor
	public TetrisGameGUIApplication() {
	}

	// Main Method
	public static void main(String[] args) {

		JFrame guiFrame = new JFrame();
		guiFrame.setSize(WIDTH, HEIGHT);
		guiFrame.add(new TetrisGameGUIController());
		guiFrame.setVisible(true);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
