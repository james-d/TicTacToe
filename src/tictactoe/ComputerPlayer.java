package tictactoe;


public class ComputerPlayer extends Player {
	
	private final MoveChoosingStrategy strategy ;
	
	public ComputerPlayer(String name, MoveChoosingStrategy strategy) {
		super(name);
		this.strategy = strategy ;
	}
	
	public ComputerPlayer(MoveChoosingStrategy strategy) {
		this("Computer", strategy);
	}
	
	
	public Location chooseMove(Game game) {
		return strategy.chooseMove(game);
	}
	
}
