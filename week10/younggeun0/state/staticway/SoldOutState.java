package week10.younggeun0.state.staticway;

public class SoldOutState extends State {
	@Override
	public void insertQuarter(GumballMachine gm) {
		System.out.println("매진 입니다.");
	}
	@Override
	public void ejectQuarter(GumballMachine gm) {
		System.out.println("매진 입니다.");
	}
	@Override
	public boolean turnCrank(GumballMachine gm) {
		System.out.println("매진 입니다.");
		return false;
	}
	@Override
	public void dispense(GumballMachine gm) {
		System.out.println("나갈 알맹이가 없습니다.");
	}
}
