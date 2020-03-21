package week10.younggeun0.state.staticway;

public class GumballMachine {
	// 이제 정적 변수를 사용하던 기존 코드를 새로 만든 클래스를 사용하는 방식으로 수정
	static final State soldOutState = new SoldOutState();
	static final State noQuarterState = new NoQuarterState();
	static final State hasQuarterState = new HasQuarterState();
	static final State soldState = new SoldState();
	static final State winnerState = new WinnerState();
	
	State state = soldOutState; // 상태 초기화
	int count = 0;
	
	public GumballMachine(int numberGumballs) {
		this.count = numberGumballs;
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}
	
	public void insertQuarter() {
		state.insertQuarter(this);
	}
	
	public void ejectQuarter() {
		state.ejectQuarter(this);
	}
	
	public void turnCrank() {
		state.turnCrank(this);
		state.dispense(this);
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void releaseBall() {
		System.out.println("껌사탕이 굴러나옵니다...");
		if (count != 0) {
			count--;
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
	public State getWinnerState() {
		return winnerState;
	}
	public State getSoldState() {
		return soldState;
	}
	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		String result = "\n남은 개수 : "+count+", state : ";
	
	   if (state instanceof HasQuarterState) {
		   result = result + "동전 있음\n";
	    } else if (state instanceof NoQuarterState) {
	    	result = result + "동전 없음\n";
	    } else if (state instanceof SoldState) {
	    	result = result + "완판\n";
	    } else if (state instanceof SoldOutState) {
	    	result = result + "판매중\n";
	    }
		
		return result;
	}
}
