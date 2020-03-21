package week10.younggeun0.state.staticway;

public class SoldOutState implements State {
	@Override
	public void insertQuarter(GumballMachine gm) {
		if (gm.state instanceof SoldOutState)
			System.out.println("매진 입니다.");
	}
	@Override
	public void ejectQuarter(GumballMachine gm) {
		if (gm.state instanceof SoldOutState)
			System.out.println("매진 입니다.");
	}
	@Override
	public void turnCrank(GumballMachine gm) {
		if (gm.state instanceof SoldOutState)
			System.out.println("매진 입니다.");
	}
	@Override
	public void dispense(GumballMachine gm) {
		if (gm.state instanceof SoldOutState)
			System.out.println("나갈 알맹이가 없습니다.");
	}
}
