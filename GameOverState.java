package snake;

/**
 * The GameOverState class extends GameState and is used when the game is over.
 * It contains a method for drawing the "Game Over" message on the screen.
 */
class GameOverState extends GameState {
    GameOverState(GamePanel panel) {
        super(panel);
    }

    /**
     * 
     * The update() method stops the timer when the game is over.
     */
    public void update() {
        panel.timer.stop();
    }

    /**
     * The draw() method calls the drawGameOver() method to draw the "Game Over"
     * message on the screen.
     */
    public void draw(Graphics g) {
        panel.drawGameOver(g);
    }
}
