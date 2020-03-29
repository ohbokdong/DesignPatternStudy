package week11.minj0i.gumball;

import java.rmi.*;
import java.rmi.server.*;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
	
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	
	State state = soldOutState;
	int count = 0;
	
	//week11 proxy 추가
	String location;

	public GumballMachine(String location, int count) throws RemoteException {
		
		this.location = location;
		
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		this.count = count;
		if (count > 0) {
			state = noQuarterState;
		}
	}
	
	public void insertQuarter() {
		state.insertQuarter();
	}
	
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	void setState(State state) {
		this.state = state;
	}
	
	void releaseBall() { 
		System.out.println("A gumball comes rolling out this slot..");
		if (count != 0) {
			count = count - 1;
		}
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getState() {
		return state;
	}

	public int getCount() {
		return count;
	}

	public State getWinnerState() {
		return winnerState;
	}
	
	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "GumballMachine [winnerState=" + winnerState
				+ ", state=" + state + ", count=" + count + "]";
	}
	
	
	
}
