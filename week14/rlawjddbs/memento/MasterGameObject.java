package week14.memento;

public class MasterGameObject {
	private String gameState;

	public String getCurrentState() {
		return gameState;
	}

	public void setState(String gameState) {
		this.gameState = gameState;
	}
	
	public GameMemento saveState() {
		return new GameMemento(gameState);
	}
	
	public void restoreState(GameMemento gameMemento) {
		gameState = gameMemento.getSavedGameState();
	}
}
