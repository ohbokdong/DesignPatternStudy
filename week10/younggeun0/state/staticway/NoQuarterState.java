package week10.younggeun0.state.staticway;

public class NoQuarterState implements State {
	@Override
	public void insertQuarter(GumballMachine gm) {
		if (gm.state instanceof NoQuarterState) {
			System.out.println("동전을 넣으셨습니다.");
			gm.setState(gm.getHasQuarterState());
		}
	}
	@Override
	public void ejectQuarter(GumballMachine gm) {
		if (gm.state instanceof NoQuarterState)
			System.out.println("동전을 넣어주세요.");
	}
	@Override
	public void turnCrank(GumballMachine gm) {
		if (gm.state instanceof NoQuarterState)
			System.out.println("동전을 넣어주세요.");
	}
	@Override
	public void dispense(GumballMachine gm) {
		if (gm.state instanceof NoQuarterState)
			System.out.println("동전을 넣어주세요.");
	}
}
