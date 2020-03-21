package week10.younggeun0.state.staticway;

import java.util.Random;

public class HasQuarterState implements State {
	static Random randomWinner = new Random(System.currentTimeMillis());
	@Override
	public void insertQuarter(GumballMachine gm) {
		if (gm.state instanceof HasQuarterState)
			System.out.println("동전은 한 개만 넣어주세요.");
	}
	@Override
	public void ejectQuarter(GumballMachine gm) {
		if (gm.state instanceof HasQuarterState) {
			System.out.println("동전이 반환됩니다.");
			gm.setState(gm.getNoQuarterState());
		}
	}
	@Override
	public void turnCrank(GumballMachine gm) {
		if (gm.state instanceof HasQuarterState) {
			System.out.println("손잡이를 돌리셨습니다.");
			int winner = randomWinner.nextInt(10);
			if ((winner == 0) && (gm.getCount() > 1)) {
				gm.setState(gm.getWinnerState());
			} else {
				gm.setState(gm.getSoldState());
			}
		}
	}
	@Override
	public void dispense(GumballMachine gm) {
		if (gm.state instanceof HasQuarterState)
			System.out.println("알맹이가 나갈 수 없습니다.");
	}
}
