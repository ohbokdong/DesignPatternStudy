package week14.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	private List<GameMemento> savedStates;
	
	public CareTaker() {
		savedStates = new ArrayList<GameMemento>();
	}
	
	public void add(GameMemento gameMemento) {
		savedStates.add(gameMemento);
	}
	
	public GameMemento get(int index) {
		return savedStates.get(index);
	}
	
	public int getLastSavedIdx() {
		return savedStates.size() - 1;
	}
}
