package week10.younggeun0.state;

public class SoldOutState implements State {
	GumballMachine2 gumballMachine;
	
	public SoldOutState(GumballMachine2 gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	@Override
	public void insertQuarter() {
		System.out.println("매진 입니다.");
	}
	@Override
	public void ejectQuarter() {
		System.out.println("매진 입니다.");
	}
	@Override
	public void turnCrank() {
		System.out.println("매진 입니다.");
	}
	@Override
	public void dispense() {
		System.out.println("나갈 알맹이가 없습니다.");
	}
}
