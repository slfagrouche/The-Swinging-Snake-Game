package snake;

/**
 * The PlayingState class extends GameState and is used when the game is in
 * progress. It contains methods for updating and drawing the game when the
 * snake is moving and eating apples.
 */
public class PlayingState extends GameState {
    PlayingState(GamePanel panel) {
        super(panel);
    }

    /**
     * The update() method calls the moveSnake() method to update the position of
     * the snake.
     */
    public void update() {
        panel.moveSnake();
    }

    /**
     * The draw() method calls the drawApple(), drawSnake(), and drawScore() methods
     * to draw the apple, the snake, and the score on the screen.
     */
    public void draw(Graphics g) {
        drawApple(g);
        drawSnake(g);
        drawScore(g);
        drawLevel(g);
    }

    /**
     * The drawApple() method draws the apple on the screen. It takes in a Graphics
     * object as a parameter and uses it to set the color, font, and position of the
     * text to be displayed.
     */
    private void drawApple(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(panel.appleXCoordinate, panel.appleYCoordinate, panel.UNIT_SIZE, panel.UNIT_SIZE);
    }

    /**
     * The drawSnake() method draws the snake on the screen. It takes in a Graphics
     * object as a parameter and uses it to set the color, font, and position of the
     * text to be displayed.
     */
    private void drawSnake(Graphics g) {
        for (int i = 0; i < panel.snakeBodyParts; i++) {
            g.setColor(i == 0 ? new Color(0, 255, 0) : new Color(45, 180, 0));
            g.fillRect(panel.xCoordinates[i], panel.yCoordinates[i], panel.UNIT_SIZE, panel.UNIT_SIZE);
        }
    }

    /**
     * The drawScore() method draws the current score on the screen. It takes in a
     * Graphics object as a parameter and uses it to set the color, font, and
     * position of the text to be displayed.
     */
    private void drawScore(Graphics g) {
        g.setColor(new Color(144, 238, 144));
        g.setFont(new Font("Pacifico", Font.BOLD, 35));
        FontMetrics metrics = panel.getFontMetrics(g.getFont());
        g.drawString("Score: " + panel.applesEaten,
                (panel.SCREEN_WIDTH - metrics.stringWidth("Score: " + panel.applesEaten)) / 2, g.getFont().getSize());
    }

    /*
     * This method is used to draw the current level of the game on the screen. It
     * takes in a Graphics object as a parameter and uses it to set the color, font,
     * and position of the text to be displayed. It uses the panel.level variable to
     * get the current level and display it on the screen.
     */
    private void drawLevel(Graphics g) {
        g.setColor(new Color(144, 222, 244));
        g.setFont(new Font("Pacifico", Font.ITALIC, 25));
        FontMetrics fontMetrics = g.getFontMetrics();
        g.drawString("Level: " + panel.level,
                panel.SCREEN_WIDTH - fontMetrics.stringWidth("Level: " + panel.level) - 20, 30);

    }
}