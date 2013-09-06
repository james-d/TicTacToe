package tictactoe;

import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Square extends StackPane {

	public Square(int column, int row, Player player, Game game) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Square.fxml"));
		loader.setRoot(this);
		final SquareController squareController = new SquareController(player, game, new Location(column, row));
		loader.setController(squareController);
		loader.load();
		GridPane.setColumnIndex(this, column);
		GridPane.setRowIndex(this, row);
	}

}
