# The-Swinging-Snake-Game
## Introduction
This is an implementation of the classic Snake game built using Java Swing. The game consists of a snake that moves around the screen, eating apples and growing longer with each apple eaten. The player's score increases with each apple eaten. The game ends when the snake collides with the edges of the screen or its own body. The game also has a game over state that is displayed when the game ends. The game can be controlled using the arrow keys. The game also includes functionality for updating the game level based on the number of apples eaten and adjusting the game speed accordingly.

## Classes and Methods
  • The main class is the GamePanel class which is a JPanel that represents the game screen.

  • It contains variables and methods for the game's logic and display such as screen size, unit size, grid size, delay between updates, coordinates of the snake and the apple, the number of apples eaten, the direction the snake is moving, and the current state of the game.

  • It also contains a Timer object to handle updates and a Random object to generate random positions for the apple.

  • The startGame method creates a new apple and starts the timer.

  • The paintComponent method is called automatically when the panel needs to be repainted. It first calls the super.paintComponent(g) method to clear the screen and then calls the draw method in the PlayingState class to draw the game on the screen and display the level status.

  • The newApple method generates a random position for the apple and checks if the level needs to be incremented.
  
## Conclusion
This Snake Game is a classic game that has been implemented using Java Swing. The game implements the basic features of a Snake game along with the level and speed updates. The game can be controlled using the arrow keys and ends when the snake collides with the edges of the screen or its own body.




### Running and Compiling the code
To compile and run the code, you need to have Java installed on your computer. Here's how you can compile and run the code:
Open a text editor and copy the code into a new file.
Save the file with a .java extension, for example, "SnakeGame.java".
Open the terminal or command prompt and navigate to the directory where you saved the file.
Compile the code by typing "javac SnakeGame.java" and press enter.
Run the code by typing "java SnakeGame" and press enter.
This will launch the game and you can start playing by using the arrow keys to control the snake. The goal of the game is to make the snake eat as many apples as possible without hitting the walls or its own body.


## Screenshots
<img width="1081" alt="SnakeShot1" src="https://user-images.githubusercontent.com/112984558/218217313-29335e69-6924-4687-ae4c-d5d6ccb03d3c.png">
<img width="1078" alt="SnakeShot2" src="https://user-images.githubusercontent.com/112984558/218217321-1f1629c1-f169-4acb-83c5-2a0f79e4b621.png">
<img width="1075" alt="SnakeShot3" src="https://user-images.githubusercontent.com/112984558/218217324-08412d25-abde-4247-8389-ea8aa821ebc4.png">
<img width="1076" alt="SnakeShot4" src="https://user-images.githubusercontent.com/112984558/218217327-52c353b0-4afd-4fce-ac06-9d237ab5a087.png">
<img width="1075" alt="SnakeShot5" src="https://user-images.githubusercontent.com/112984558/218217329-928ce116-711b-4adf-9679-4b8f0a619c9e.png">

