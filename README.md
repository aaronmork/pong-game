# pong-game

FInal school Java class project

### Pong Game Specification (MVC Architecture)

#### Model

- **Game State**: Tracks positions of two vertical paddles (left and right sides), ball(s) (starting with 1, max 2), ball speed (increases as lives decrease), and direction.
- **Players**: Two players (Player 1: left paddle controlled by user; Player 2: right paddle, assumed AI or second player).
- **Lives/Scoring**: Each player starts with 3 lives. Scoring occurs when ball hits opponent's wall (subtracts 1 life from opponent). Game ends when a player's lives reach 0.
- **Ball Mechanics**: Ball glides across screen, bounces off paddles and top/bottom walls. Additional ball spawns when a player reaches 1 life. No power-ups.
- **Reset**: 'R' key resets game state (lives to 3, balls to 1, speed to initial).

#### View

- **Swing Components**: JFrame window displaying game area.
- **Displayed Elements**: Two vertical paddles, ball(s), background, lives counter for each player.
- **Rendering**: Real-time updates of paddle/ball positions, lives display.

#### Controller

- **Input Handling**: Arrow keys (up/down) control left paddle movement.
- **Game Loop**: Updates ball position, checks collisions (paddle/wall), spawns extra balls, adjusts speed, detects scoring.
- **Events**: Processes key presses (movement, restart), triggers model updates and view refreshes.

Prompt 1:
I'm building a pong game in Java using Swing, split into three files: GameModel.java, GameView.java, and GameController.java. GameView should extend JPanel and be hosted in a JFrame. GameController should have the main method and wire the three classes together. GameModel must have no Swing imports. For now, just create the three class shells with placeholder comments describing what each class will do. The program should compile and open a blank window.

Result:
Created the framework for my pong game.
