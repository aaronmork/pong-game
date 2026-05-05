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

Prompt 5:
I noticed the slab was very slow and couldn't keep up with the ball. The AI must've not thought about that relative to the ball speed. I found the slab speed value and increassed it by 6x so I can keep up.

Result:
Due to the speed increase the game is now actually playable. But I still have the problem with the other slab not moving.

Prompt 6:
In GameModel.java, add a method that allows AI to controll the slab on the right side. Do not modify FrogView or FrogController.

Result:
The oppnents slab still does not move. I suspect it's because I told it not to mess with other files. I think this caused the code to be added partially.

Prompt 7:
The opponent slab is not moving, I figure its from being in the GameModel file but not being called in the GameController file. Call the method so it allows the slab to be controlled by AI.

Result:
My suspicions were correct, the problem was due to the AI control value not being added into the GameController file. The AI not only moves and survives, it does not lose. I fear I have created the best pong player.

Prompt 8:
Once the game is over I have to close and open a window to play again. I want to be able to restart the game by pressing the "r" key.

Result:
I veiwed the code and saw that it was very easy to add this in, only 9 lines. The code works and let me reset when I wanted to. AI even made sure that the opponent didn't self destruct when I reset the game.

Prompt 9:
I'm thinking about making the ball speed increase as the player lose lives. Which files would be the best place for the code to go?

Result:
It told me it would only change in the GameModel file. Once I read over the code and understood it I asked it to add the code into the file. The result turned out great and everytime a live was lost the ball increased in speed.

Prompt 10:
I want to add the word PONG on the botton of the window, which file would that go in?

Result:
I thought it would be in the view file but I just wanted to make sure. It added it perfectly and had no problems. But after it added the word PONG, I thought it would be better to kinda watermark this game by adding "BY AARON" after.

Prompt 11:
I want to make it so everytime the ball hit off a wall, or off a players slab a ding sound occurs. Where would this file be placed?

Result:
AI added a boolean in places where the ball was coded. I overlooked the code it wrote until I understood it fairy well. When I tested out the game it was successful in adding a ping sound everytime the ball bounced.

Prompt 12:
Create a background that has a checkered pattern. Make the background consist of two colors, Green and Ivory.

Result:
The background got changed the the color I wanted. But this came with a problem, the slabs, ball, and text on the screen blends in with the ivory color. So I had to come back and change the text, slab and ball color to black.
