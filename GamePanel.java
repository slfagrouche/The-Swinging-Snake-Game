package snake;

/** Snake Game
 * @author Said Lfagrouche
 * 
 * Snake Game is an implementation of the classic Snake game using Java Swing.
 * The game consists of a snake that moves around the screen and eats apples.
 * The snake's body grows with every apple it eats and the player's score increases.
 * The game ends when the snake collides with the edges of the screen or with its own body.
 * The game also has a game over state that is displayed when the game ends.
 * The game can be controlled with the arrow keys. 
 * Additionally, it includes functionality for updating the game level based on the number of apples eaten 
 * and adjusting the game speed accordingly.
 **/
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * The GamePanel class is a JPanel that represents the game screen in a Snake
 * game. It contains variables and methods for the game's logic and display,
 * such as the size of the screen, the size of each unit, the number of units in
 * the game, the delay between updates, the coordinates of the snake and the
 * apple, the number of apples eaten, the direction the snake is moving, and the
 * current state of the game. It also contains a Timer object to handle updates
 * and a Random object to generate random positions for the apple.
 */
public class GamePanel extends JPanel {

	// Constants for the screen size, unit size, and number of game units
	public static final int SCREEN_WIDTH = 1200;
	public static final int SCREEN_HEIGHT = 700;
	public static final int UNIT_SIZE = 30;
	public static final int GRID_SIZE = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);

	// Constant for the delay between updates
	private static int DELAY = 180;

	// Arrays for the x and y coordinates of the snake
	public final int xCoordinates[] = new int[GRID_SIZE];
	public final int yCoordinates[] = new int[GRID_SIZE];

	// Variables for the number of snake body parts, number of apples eaten, and the
	// apple's coordinates
	public int snakeBodyParts = 3;
	public int applesEaten;
	public int appleXCoordinate;
	public int appleYCoordinate;
	public int level = 1;

	// Variable for the direction the snake is moving
	private char direction = 'R';

	// Timer object to handle updates
	public Timer timer;

	// Random object to generate random positions for the apple
	private Random randomGenerator;

	// Variable for the current state of the game
	private GameState currentState;

	/**
	 * The constructor sets the size of the screen, the background color, and the
	 * focusability of the panel, as well as adding a key listener to handle input
	 * and starting the game.
	 */
	GamePanel() {
		randomGenerator = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(new Color(51, 51, 51));
		this.setFocusable(true);
		this.addKeyListener(new SnakeKeyAdapter());
		currentState = new PlayingState(this);
		startGame();
	}

	/**
	 * The startGame() method creates a new apple and starts the timer.
	 */
	public void startGame() {
		newApple();
		timer = new Timer(DELAY, new ActionListener() {
			/**
			 * The actionPerformed() method updates the current state and repaints the
			 * screen on each tick of the timer.
			 */
			public void actionPerformed(ActionEvent e) {
				currentState.update();
				repaint();
			}
		});

		timer.start();
	}

	/**
	 * This method is called automatically when the panel needs to be repainted. It
	 * first calls the super.paintComponent(g) method which clears the screen. Then
	 * it calls the draw() method in the PlayingState class to draw the game on the
	 * screen and display the level status.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		currentState.draw(g);

	}

	/**
	 * The newApple() method generates a random position for the apple and also
	 * check if the level needs to be incremented
	 */

	public void newApple() {
		int maxX = (int) (SCREEN_WIDTH / UNIT_SIZE) - 1;
		int maxY = (int) (SCREEN_HEIGHT / UNIT_SIZE) - 1;
		appleXCoordinate = randomGenerator.nextInt(maxX) * UNIT_SIZE;
		appleYCoordinate = randomGenerator.nextInt(maxY) * UNIT_SIZE;

		applesEaten++;
		if (applesEaten % 10 == 0) {
			level++;
			if (timer == null) {
				startGame();
			}
			updateDelay();
		}
	}

	/**
	 * The updateDelay() method is used to update the delay based on the current
	 * level
	 */
	public void updateDelay() {
		if (level == 2) {
			DELAY = 160;
		} else if (level == 3) {
			DELAY = 140;
		} else if (level == 4) {
			DELAY = 120;
		} else if (level == 5) {
			DELAY = 100;
		} else if (level == 6) {
			DELAY = 80;
		} else if (level == 6) {
			DELAY = 60;
		} else if (level == 6) {
			DELAY = 55;
		}

		timer.setDelay(DELAY);
	}

	/**
	 * The moveSnake() method updates the position of the snake based on the current
	 * direction.
	 */
	public void moveSnake() {
		// Loop through all the body parts, starting from the tail
		// Move the current body part to the position of the previous one
		for (int i = snakeBodyParts; i > 0; i--) {
			xCoordinates[i] = xCoordinates[i - 1];
			yCoordinates[i] = yCoordinates[i - 1];
		}

		// Move the head based on the current direction
		switch (direction) {
		case 'R':
			xCoordinates[0] += UNIT_SIZE;
			break;
		case 'L':
			xCoordinates[0] -= UNIT_SIZE;
			break;
		case 'U':
			yCoordinates[0] -= UNIT_SIZE;
			break;
		case 'D':
			yCoordinates[0] += UNIT_SIZE;
			break;
		}
		checkCollision();
	}

	/**
	 * The checkCollision() method checks if the snake has collided with the edges
	 * of the screen or with its own body and changes the state of the game if
	 * necessary.
	 */
	public void checkCollision() {
		if (xCoordinates[0] > SCREEN_WIDTH || xCoordinates[0] < 0 || yCoordinates[0] > SCREEN_HEIGHT
				|| yCoordinates[0] < 0) {
			currentState = new GameOverState(this);
		}
		for (int i = 1; i < snakeBodyParts; i++) {
			if (xCoordinates[i] == xCoordinates[0] && yCoordinates[i] == yCoordinates[0]) {
				currentState = new GameOverState(this);
			}
		}
		if (xCoordinates[0] == appleXCoordinate && yCoordinates[0] == appleYCoordinate) {
			snakeBodyParts++;

			newApple();
		}
	}

	/*
	 * Display the "Game Over" message on the screen when the game is over
	 */
	public void drawGameOver(Graphics g) {
		g.setColor(new Color(192, 192, 192));
		g.setFont(new Font("Pacifico", Font.BOLD, 65));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2 - 50);
		g.setColor(new Color(128, 128, 128));
		g.drawString("Final Score: " + applesEaten,
				(SCREEN_WIDTH - metrics.stringWidth("Final Score: " + applesEaten)) / 2, (SCREEN_HEIGHT / 2) + 25);
	}

	/**
	 * The SnakeKeyAdapter class is a KeyAdapter that handles input from the user.
	 * It changes the direction of the snake based on the key pressed by the user.
	 */
	private class SnakeKeyAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if (direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if (direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if (direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
	}

}

