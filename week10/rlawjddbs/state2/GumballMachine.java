package week10.state2;

public class GumballMachine {
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	
	State state = soldOutState;
	int count = 0;
	
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
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
}
