package week10.younggeun0.state.staticway;

import java.util.Random;

public class HasQuarterState extends State {
	static Random randomWinner = new Random(System.currentTimeMillis());
	@Override
	public void insertQuarter(GumballMachine gm) {
		System.out.println("동전은 한 개만 넣어주세요.");
	}
	@Override
	public void ejectQuarter(GumballMachine gm) {
		System.out.println("동전이 반환됩니다.");
		gm.setState(StaticState.noQuarterState);
	}
	@Override
	public boolean turnCrank(GumballMachine gm) {
		System.out.println("손잡이를 돌리셨습니다.");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gm.getCount() > 1)) {
			gm.setState(StaticState.winnerState);
			return true;
		} else {
			gm.setState(StaticState.soldState);
			return true;
		}
	}
	@Override
	public void dispense(GumballMachine gm) {
		System.out.println("알맹이가 나갈 수 없습니다.");
	}
}
