
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Rafay
 *
 *         Tetris Game GUI Controller class. Includes a constructor, timer
 *         method, key event methods and a return game method.
 */

public class TetrisGameGUIController extends JPanel implements KeyListener {
	// Variables for classes
	private TetrisGame game;
	private TetrisBoardGUIView view;

	// get the Timer
	private Timer gameTimer;
	// private static final long serialVersionUID = 1L;
	// text variables
	public static String text1;
	public static String text2;
	// JPanel/text variables
	private JTextArea linesCleared = new JTextArea();
	private JTextArea tetrisCleared = new JTextArea();
	private JPanel scorecard;

	// Constructor
	public TetrisGameGUIController() {
		super(new BorderLayout());
		setFocusable(true);
		addKeyListener(this);
		setupTimer();
		game = new TetrisGame();

		scorecard = new JPanel();
		text1 = "Lines cleared: " + game.getlinesCleared();
		text2 = "Tetrises cleared: " + game.gettetrisesCleared();

		scorecard.setLayout(new GridLayout(2, 1));
		scorecard.add(linesCleared);
		scorecard.add(tetrisCleared);
		add(scorecard, BorderLayout.NORTH);

		view = new TetrisBoardGUIView();
		add(view, BorderLayout.CENTER);

	}

	// Timer method
	private void setupTimer() {

		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				game.attemptMove(4);
				view.setTetrisBoard(game.getTetrisBoard());
				linesCleared.setText("Lines cleared:" + " " + game.getlinesCleared());
				tetrisCleared.setText("Tetrises cleared:" + " " + game.gettetrisesCleared());

				repaint();
			}
		};

		gameTimer = new Timer(1000, a);
		gameTimer.start();
	}

	// return the game
	public TetrisGame returnGame() {
		return game;
	}

	// KeyPressed event
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {

		case KeyEvent.VK_DOWN: {
			game.attemptMove(4);
		}
			break;
		case KeyEvent.VK_LEFT:
			game.attemptMove(5);
			break;
		case KeyEvent.VK_RIGHT:
			game.attemptMove(1);
			break;

		case KeyEvent.VK_UP:

			game.attemptMove(2);
			break;

		}

	}

	// key released event
	public void keyReleased(java.awt.event.KeyEvent e) {

	}

	// key typed event
	public void keyTyped(java.awt.event.KeyEvent e) {

	}

}
