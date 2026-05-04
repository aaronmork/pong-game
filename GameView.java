import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

public class GameView extends JPanel {
    private final GameModel model;

    public GameView(GameModel model) {
        this.model = model;
        setPreferredSize(new Dimension(800, 600));
        // Configure the panel for rendering the Pong game.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Render the paddles, ball(s), background, and lives display.
        // This is a placeholder until the game model and rendering are implemented.
    }
}
