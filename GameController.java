import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GameController {
    private final GameModel model;
    private final GameView view;
    private Timer gameTimer;

    public GameController() {
        model = new GameModel();
        view = new GameView(model);
        createAndShowGui();
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame("Pong Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        setupKeyboardControls();
        startGameLoop();
        frame.setVisible(true);
    }

    private void startGameLoop() {
        gameTimer = new Timer(16, e -> {
            if (model.getLeftLives() > 0 && model.getRightLives() > 0) {
                model.updateAIPaddle();
                model.updateGameState();
                if (model.consumeBounce()) {
                    Toolkit.getDefaultToolkit().beep();
                }
                view.repaint();
            } else {
                gameTimer.stop();
            }
        });
        gameTimer.start();
    }

    private void setupKeyboardControls() {
        view.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    model.movePlayerUp();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    model.movePlayerDown();
                } else if (e.getKeyCode() == KeyEvent.VK_R) {
                    model.resetGame();
                    if (!gameTimer.isRunning()) {
                        gameTimer.start();
                    }
                    view.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
        view.setFocusable(true);
        view.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameController::new);
    }
}
