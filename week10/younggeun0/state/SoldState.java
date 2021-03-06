package week10.younggeun0.state;

public class SoldState implements State {
	GumballMachine2 gumballMachine;
	
	public SoldState(GumballMachine2 gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	@Override
	public void insertQuarter() {
		System.out.println("잠깐만 기다려 주세요. 알맹이가 나가고 있습니다");
	}
	@Override
	public void ejectQuarter() {
		System.out.println("이미 알맹이를 뽑으셨습니다.");
	}
	@Override
	public void turnCrank() {
		System.out.println("손잡이는 한 번만 돌려주세요.");
	}
	@Override
	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("Opps, 다 팔렸네");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
}
