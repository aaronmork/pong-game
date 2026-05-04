public class GameModel {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    public static final int PADDLE_WIDTH = 10;
    public static final int PADDLE_HEIGHT = 100;
    public static final int BALL_SIZE = 16;
    public static final int PADDLE_SPEED = 40;
    public static final int INITIAL_LIVES = 3;
    public static final double INITIAL_BALL_SPEED = 5.0;

    private final int leftPaddleX = 50;
    private final int rightPaddleX = GAME_WIDTH - 50 - PADDLE_WIDTH;

    private int leftPaddleY;
    private int rightPaddleY;
    private double ballX;
    private double ballY;
    private double ballVelocityX;
    private double ballVelocityY;
    private int leftLives;
    private int rightLives;

    public GameModel() {
        resetGame();
    }

    public void resetGame() {
        leftPaddleY = (GAME_HEIGHT - PADDLE_HEIGHT) / 2;
        rightPaddleY = (GAME_HEIGHT - PADDLE_HEIGHT) / 2;
        leftLives = INITIAL_LIVES;
        rightLives = INITIAL_LIVES;
        resetBall();
    }

    private void resetBall() {
        ballX = (GAME_WIDTH - BALL_SIZE) / 2.0;
        ballY = (GAME_HEIGHT - BALL_SIZE) / 2.0;
        ballVelocityX = Math.random() < 0.5 ? -INITIAL_BALL_SPEED : INITIAL_BALL_SPEED;
        ballVelocityY = (Math.random() * 2 - 1) * INITIAL_BALL_SPEED;
    }

    public void movePlayerUp() {
        leftPaddleY -= PADDLE_SPEED;
        if (leftPaddleY < 0) {
            leftPaddleY = 0;
        }
    }

    public void movePlayerDown() {
        leftPaddleY += PADDLE_SPEED;
        if (leftPaddleY + PADDLE_HEIGHT > GAME_HEIGHT) {
            leftPaddleY = GAME_HEIGHT - PADDLE_HEIGHT;
        }
    }

    public void updateGameState() {
        ballX += ballVelocityX;
        ballY += ballVelocityY;

        if (ballY <= 0) {
            ballY = 0;
            ballVelocityY = -ballVelocityY;
        } else if (ballY + BALL_SIZE >= GAME_HEIGHT) {
            ballY = GAME_HEIGHT - BALL_SIZE;
            ballVelocityY = -ballVelocityY;
        }

        if (ballVelocityX < 0 && intersectsLeftPaddle()) {
            ballX = leftPaddleX + PADDLE_WIDTH;
            ballVelocityX = -ballVelocityX;
        } else if (ballVelocityX > 0 && intersectsRightPaddle()) {
            ballX = rightPaddleX - BALL_SIZE;
            ballVelocityX = -ballVelocityX;
        }

        if (ballX <= 0) {
            leftLives = Math.max(0, leftLives - 1);
            resetBall();
        } else if (ballX + BALL_SIZE >= GAME_WIDTH) {
            rightLives = Math.max(0, rightLives - 1);
            resetBall();
        }
    }

    private boolean intersectsLeftPaddle() {
        return ballX <= leftPaddleX + PADDLE_WIDTH
            && ballX >= leftPaddleX
            && ballY + BALL_SIZE >= leftPaddleY
            && ballY <= leftPaddleY + PADDLE_HEIGHT;
    }

    private boolean intersectsRightPaddle() {
        return ballX + BALL_SIZE >= rightPaddleX
            && ballX + BALL_SIZE <= rightPaddleX + PADDLE_WIDTH
            && ballY + BALL_SIZE >= rightPaddleY
            && ballY <= rightPaddleY + PADDLE_HEIGHT;
    }

    public int getLeftPaddleY() {
        return leftPaddleY;
    }

    public int getRightPaddleY() {
        return rightPaddleY;
    }

    public int getLeftPaddleX() {
        return leftPaddleX;
    }

    public int getRightPaddleX() {
        return rightPaddleX;
    }

    public int getBallX() {
        return (int) ballX;
    }

    public int getBallY() {
        return (int) ballY;
    }

    public int getLeftLives() {
        return leftLives;
    }

    public int getRightLives() {
        return rightLives;
    }
}
