package week14.memento;

public class GameMemento {
	private String savedGameState;
	
	public GameMemento(String savedGameState) {
		this.savedGameState = savedGameState;
	}
	
	public String getSavedGameState() {
		return savedGameState;
	}
}
