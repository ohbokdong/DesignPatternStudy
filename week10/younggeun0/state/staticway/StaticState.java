package week10.younggeun0.state.staticway;

public class StaticState {
	static final State soldOutState = new SoldOutState();
	static final State noQuarterState = new NoQuarterState();
	static final State hasQuarterState = new HasQuarterState();
	static final State soldState = new SoldState();
	static final State winnerState = new WinnerState();
}
