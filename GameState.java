package snake;

/**
 * The GameState abstract class is a template for the different states of the
 * game. It contains a reference to the GamePanel and two abstract methods,
 * update() and draw(). These methods will be overridden by subclasses to update
 * and draw the game state on the screen.
 */
public abstract class GameState {
    GamePanel panel;

    GameState(GamePanel panel) {
        this.panel = panel;
    }

    /**
     * The update() method is a template method that will be overridden by
     * subclasses to update the game state.
     */
    public abstract void update();

    /**
     * The draw() method is a template method that will be overridden by subclasses
     * to draw the game state on the screen.
     */
    public abstract void draw(Graphics g);
}