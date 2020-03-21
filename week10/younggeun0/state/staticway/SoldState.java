package week10.younggeun0.state.staticway;

public class SoldState implements State {
	@Override
	public void insertQuarter(GumballMachine gm) {
		if (gm.state instanceof SoldState)
			System.out.println("잠깐만 기다려 주세요. 알맹이가 나가고 있습니다");
	}
	@Override
	public void ejectQuarter(GumballMachine gm) {
		if (gm.state instanceof SoldState)
			System.out.println("이미 알맹이를 뽑으셨습니다.");
	}
	@Override
	public void turnCrank(GumballMachine gm) {
		if (gm.state instanceof SoldState)
			System.out.println("손잡이는 한 번만 돌려주세요.");
	}
	@Override
	public void dispense(GumballMachine gm) {
		if (gm.state instanceof SoldState) {
			gm.releaseBall();
			if (gm.getCount() > 0) {
				gm.setState(gm.getNoQuarterState());
			} else {
				System.out.println("Opps, 다 팔렸네");
				gm.setState(gm.getSoldOutState());
			}
		}
	}
}
