package week10.younggeun0.state.staticway;

public class WinnerState implements State {
	@Override
	public void insertQuarter(GumballMachine gm) {
		if (gm.state instanceof WinnerState)
		System.out.println("알맹이가 나옵니다");
	}
	@Override
	public void ejectQuarter(GumballMachine gm) {
		if (gm.state instanceof WinnerState)
		System.out.println("알맹이가 나옵니다");
	}
	@Override
	public void turnCrank(GumballMachine gm) {
		if (gm.state instanceof WinnerState)
		System.out.println("알맹이가 나옵니다");
	}
	@Override
	public void dispense(GumballMachine gm) {
		if (gm.state instanceof WinnerState) {
			System.out.println("축하합니다! 알맹이를 하나 더 받으실 수 있습니다.");
			gm.releaseBall();
			if (gm.getCount() == 0) {
				gm.setState(gm.getSoldOutState());
			} else {
				// 알맹이가 하나 더 있다면 한 개 더 내보냄
				gm.releaseBall();
				if (gm.getCount() > 0) {
					gm.setState(gm.getNoQuarterState());
				} else {
					System.out.println("더 이상 알맹이가 없습니다.");
					gm.setState(gm.getSoldOutState());
				}
			}
		}
	}
}
