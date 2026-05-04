# pong-game

FInal school Java class project

AI - Interview

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

Prompt 2:
Fill in GameModel.java. The model should track: the player's vertical position, the ball (starting in the middle and bounces to a random side to start the game), the player's slab,the lives, and lives remaining (start with 3). Add logic to: move the player's slab up and down, have the ball bounce off the top and bottom of the screen and bounce when it hits a player's slab, have it detect when the ball hits the player's walls and subtract a life from who got hit. No Swing imports.

Result:
Added more framework to the game and will allow me to go on to GameView to try the game.

Prompt 3:
Fill in GameView.java. It should take a reference to the model and draw everything the player sees: the player's slab, the ball, the lives, and remaining lives. Show a centered game-over message when the game ends (a player's lives hit 0). The view should only read from the model — it must never change game state.

Result:
When I ran the code it gave me a window with a ball in the middle along with both of the players slabs. The lives were also shown on the top of the window. The game was not yet playable.

Prompt 4:
Fill in GameController.java. Add keyboard controls so the player can move up and and with the arrow keys. Add a game loop using a Swing timer that updates the model each tick and redraws the view. Stop the loop when the game is over. Do not modify GameView or GameModel. Show me only the new method — I will paste it in.

Result:
I reviewed the code it gave me, I saw it didn't try and push the boundaries that I put up. After I saw it was what I asked for I pasted it in and added the imports like it said. I ran the game and it gave me a playable game, but only my slab would move.
