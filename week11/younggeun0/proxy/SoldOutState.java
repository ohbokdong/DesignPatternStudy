package week11.younggeun0.proxy;

public class SoldOutState implements State {
	transient GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	@Override
	public void insertQuarter() {
		System.out.println("매진 입니다.");
	}
	@Override
	public void ejectQuarter() {
		System.out.println("매진 입니다.");
	}
	@Override
	public void turnCrank() {
		System.out.println("매진 입니다.");
	}
	@Override
	public void dispense() {
		System.out.println("나갈 알맹이가 없습니다.");
	}
	@Override
	public String toString() {
		return "완판";
	}
}
