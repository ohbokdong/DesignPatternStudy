package week11.proxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
	static final State soldOutState = new SoldOutState();
	static final State noQuarterState = new NoQuarterState();
	static final State hasQuarterState = new HasQuarterState();
	static final State soldState = new SoldState();
	static final State winnerState = new WinnerState();
	
	private String location;
	
	State state = soldOutState;
	int count = 0;
	
	public GumballMachine(String location, int numberGumballs) throws RemoteException{
		count = numberGumballs;
		if(numberGumballs > 0) {
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
		System.out.println("알맹이가 굴러 나갑니다.");
		if (count != 0) {
			count = count - 1;
		}
	}
	
	public int getCount() {
		return count;
	}
	
	public State getState() {
		return state;
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
	
	public State getWinnerState() {
		return winnerState;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("\n주식회사 왕뽑기\n");
		sb.append("자바로 돌아가는 2004년형 뽑기 기계\n")
		.append("남은 개수 : " + count + "\n");
		if(state == noQuarterState) {
			sb.append("동전 투입 대기중\n");
		} else if(state == soldOutState) {
			sb.append("매진\n");
		}
		return sb.toString();
	}

	@Override
	public String getLocation() throws RemoteException {
		return location;
	}
}
