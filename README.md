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

I am building a pong in Java with Swing using MVC. Here is my spec:

[pasted my full spec from README.md]

Generate three class shells — GameModel.java, GameView.java, GameController.java — with method stubs based on this design. GameModel must not import any Swing classes. The program should compile and open a blank window.

Result:
Created the framework for my pong game.
