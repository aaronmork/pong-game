import javax.swing.JPanel;
import java.awt.Graphics;

public class GameView extends JPanel {
    private final GameModel model;

    public GameView(GameModel model) {
        this.model = model;
        // Configure the panel appearance here if needed.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the game objects here using the model state.
        // Example: paddles, ball(s), background, score/lives display.
    }
}
