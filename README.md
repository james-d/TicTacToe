TicTacToe
=========

JavaFX Tic Tac Toe (Human vs Computer) game

Simple implementation of a Human vs Computer Tic-Tac-Toe (Noughts and Crosses) game written in Java with JavaFX as the UI Toolkit. Compiled under Java 1.7.0_25 using E(fx)clipse. Tested on Mac OS X 10.7.5.

The algorithm for implementing the computer player's strategy was based on http://www.eecs.berkeley.edu/~bh/ssch10/ttt.html

The game is written using a fairly strict MVC approach. The Game class represents the state of the game (players, state of each square, won/drawn/still-paying state, etc) with various state represented by JavaFX observable properties. The UI is defined by two FXML files: TicTacToe.fxml (for the overall UI) and Square.fxml (which is used to create each square on the board). The corresponding controllers bind the state of the UI to the state of the Game class. In particular, the labels used to render O and X have their visibility bound (in SquareController) to the state of the corresponding location in the Game class.

The GameController also observes the currentPlayer property of the Game class, and when it changes to the computer player, asks the computer player to calculate its next move. A strategy pattern is used to plug in the "calculate next move" strategy. The GameController asks the computer player to calculate the next move on a background thread, using a javafx.concurrent.Task implementaion. This is not really necessary as in such a simple game this calculation is effectively instantaneous from the viewpoint of the user; however this demonstrates the technique required for more complex games.

Limitations:

1. Not tested outside the development environment (JDK 1.7.0_25 and JDK 1.8.0 b103 on Mac OS X 10.7.5).

2. Computer cannot be beaten, so this gets boring quickly.
