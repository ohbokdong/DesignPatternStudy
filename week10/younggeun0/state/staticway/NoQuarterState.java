package week10.younggeun0.state.staticway;

public class NoQuarterState extends State {
	@Override
	public void insertQuarter(GumballMachine gm) {
		System.out.println("동전을 넣으셨습니다.");
		gm.setState(StaticState.hasQuarterState);
	}
	@Override
	public void ejectQuarter(GumballMachine gm) {
		System.out.println("동전을 넣어주세요.");
	}
	@Override
	public boolean turnCrank(GumballMachine gm) {
		System.out.println("동전을 넣어주세요.");
		return false;
	}
	@Override
	public void dispense(GumballMachine gm) {
		System.out.println("동전을 넣어주세요.");
	}
}
