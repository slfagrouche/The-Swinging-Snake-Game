package snake;

import javax.swing.JFrame;


/**
 * The Main class creates a JFrame and adds a GamePanel to it.
 * It also sets the JFrame's properties such as size, location, and close operation.
 */
public class SnakeGame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Snake Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(new GamePanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}