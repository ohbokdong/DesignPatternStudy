package week10.younggeun0.state.staticway;

public class WinnerState extends State {
	@Override
	public void dispense(GumballMachine gm) {
		System.out.println("축하합니다! 알맹이를 하나 더 받으실 수 있습니다.");
		gm.releaseBall();
		if (gm.getCount() == 0) {
			gm.setState(StaticState.soldOutState);
		} else {
			// 알맹이가 하나 더 있다면 한 개 더 내보냄
			gm.releaseBall();
			if (gm.getCount() > 0) {
				gm.setState(StaticState.noQuarterState);
			} else {
				System.out.println("더 이상 알맹이가 없습니다.");
				gm.setState(StaticState.soldOutState);
			}
		}
	}
}
