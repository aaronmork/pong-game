import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

public class GameView extends JPanel {
    private final GameModel model;

    public GameView(GameModel model) {
        this.model = model;
        setPreferredSize(new Dimension(GameModel.GAME_WIDTH, GameModel.GAME_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw checkered background.
        Color ivory = new Color(255, 255, 240);
        Color green = new Color(0, 128, 0);
        int tileSize = 50;

        for (int y = 0; y < getHeight(); y += tileSize) {
            for (int x = 0; x < getWidth(); x += tileSize) {
                boolean even = ((x / tileSize) + (y / tileSize)) % 2 == 0;
                g2.setColor(even ? green : ivory);
                g2.fillRect(x, y, tileSize, tileSize);
            }
        }

        // Draw paddles and ball.
        g2.setColor(Color.BLACK);
        g2.fillRect(model.getLeftPaddleX(), model.getLeftPaddleY(), GameModel.PADDLE_WIDTH, GameModel.PADDLE_HEIGHT);
        g2.fillRect(model.getRightPaddleX(), model.getRightPaddleY(), GameModel.PADDLE_WIDTH, GameModel.PADDLE_HEIGHT);
        g2.fillOval(model.getBallX(), model.getBallY(), GameModel.BALL_SIZE, GameModel.BALL_SIZE);

        // Draw lives.
        g2.setFont(new Font("SansSerif", Font.BOLD, 20));
        g2.drawString("Player Left Lives: " + model.getLeftLives(), 20, 30);
        g2.drawString("Player Right Lives: " + model.getRightLives(), getWidth() - 220, 30);

        // Draw "PONG" at the bottom
        g2.setFont(new Font("SansSerif", Font.BOLD, 24));
        int pongWidth = g2.getFontMetrics().stringWidth("PONG BY AARON");
        g2.drawString("PONG BY AARON", (getWidth() - pongWidth) / 2, getHeight() - 20);

        // Draw game over if a player has no lives remaining.
        if (model.getLeftLives() == 0 || model.getRightLives() == 0) {
            String message = model.getLeftLives() == 0 ? "Right Player Wins!" : "Left Player Wins!";
            g2.setFont(new Font("SansSerif", Font.BOLD, 36));
            int textWidth = g2.getFontMetrics().stringWidth(message);
            int textHeight = g2.getFontMetrics().getHeight();
            g2.drawString(message, (getWidth() - textWidth) / 2, (getHeight() / 2) + (textHeight / 4));
        }
    }
}
