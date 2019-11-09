package memento;

import java.util.Stack;

import memento.abc.Memento;
import memento.abc.Originator;

public class Application {

	public static void main(String[] args) {
		
		// CareTaker는 Stack으로 사용
		Stack<Memento> mementos = new Stack<>();
		
		Originator originator = new Originator();
		
		originator.setState("state 1");
		mementos.push(originator.createMemento());
		
		originator.setState("state 2");
		mementos.push(originator.createMemento());
		
		originator.setState("state 3");
		mementos.push(originator.createMemento());
		
		originator.setState("state Final");
		mementos.push(originator.createMemento());
		
		originator.restoreMemento(mementos.pop());
		System.out.println(originator.getState()); // state final
		
		originator.restoreMemento(mementos.pop());
		System.out.println(originator.getState()); // state 3
		
		originator.restoreMemento(mementos.pop());
		System.out.println(originator.getState()); // state 2
		
		originator.restoreMemento(mementos.pop());
		System.out.println(originator.getState()); // state 1
	}
}
