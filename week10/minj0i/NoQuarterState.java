package week10.minj0i;

public class NoQuarterState implements State {
	GumballMachine2 gumballMachine;
	
	public NoQuarterState(GumballMachine2 gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("동전을 넣으셨습니다.");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("동전을 넣어주세요.");
	}

	@Override
	public void turnCrank() {
		System.out.println("동전을 넣어주세요");
	}

	@Override
	public void dispense() {
		System.out.println("동전을 넣어주세요");
	}

}
