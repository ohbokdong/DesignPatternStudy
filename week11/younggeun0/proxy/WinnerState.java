package week11.younggeun0.proxy;

public class WinnerState implements State {
	transient GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	@Override
	public void insertQuarter() {
		System.out.println("알맹이가 나옵니다");
	}
	@Override
	public void ejectQuarter() {
		System.out.println("알맹이가 나옵니다");
	}
	@Override
	public void turnCrank() {
		System.out.println("알맹이가 나옵니다");
	}
	@Override
	public void dispense() {
		System.out.println("축하합니다! 알맹이를 하나 더 받으실 수 있습니다.");
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			// 알맹이가 하나 더 있다면 한 개 더 내보냄
			gumballMachine.releaseBall();
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
				System.out.println("더 이상 알맹이가 없습니다.");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}
	@Override
	public String toString() {
		return "두 개 찬스";
	}
}
