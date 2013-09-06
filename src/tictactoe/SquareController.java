package tictactoe;

import tictactoe.Game.SquareState;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class SquareController {
	private final Player player ;
	private final Game game ;
	private final Location location ;

	@FXML
	private StackPane root ;
	@FXML
	private Label oLabel ;
	@FXML 
	private Label xLabel ;
	
	public SquareController(Player player, Game game, Location location) {
		this.player = player ;
		this.game = game ;
		this.location = location ;
	}
	
	public void initialize() {
		root.disableProperty().bind(
			game.currentPlayerProperty().isNotEqualTo(player)
			.or(game.gameStatusProperty().isNotEqualTo(Game.GameStatus.OPEN))
			.or(game.squareProperty(location).isNotEqualTo(Game.SquareState.EMPTY))
		);
		oLabel.visibleProperty().bind(game.squareProperty(location).isEqualTo(SquareState.O));
		xLabel.visibleProperty().bind(game.squareProperty(location).isEqualTo(SquareState.X));

	}

	@FXML
	public void makeMove() {
		game.makeMove(player, location);
	}
}
