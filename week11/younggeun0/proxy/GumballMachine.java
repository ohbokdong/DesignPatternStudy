package week11.younggeun0.proxy;

public class GumballMachine {
	
	String location; // 기타 인스턴스 변수
	
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	
	State state = soldOutState;
	int count = 0;
	
	public GumballMachine(int numberGumballs, String location) {
		// 기타 생성자 코드
		this.location = location;
		
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		
		this.count = numberGumballs;
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}
	
	public String getLocation() {
		return location;
	}
	public State getState() {
		return state;
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
