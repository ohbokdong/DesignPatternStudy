package week10.rlawjddbs.state2;

public class SoldOutState implements State {
	GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("동전을 넣으셨습니다.");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("동전이 반환 되었습니다.");
	}

	@Override
	public void turnCrank() {
		System.out.println("매진 되었습니다.");
	}

	@Override
	public void dispense() {
		System.out.println("매진 되었습니다.");
	}

}
