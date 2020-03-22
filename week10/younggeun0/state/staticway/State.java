package week10.younggeun0.state.staticway;

public abstract class State { // #1
	public void insertQuarter(GumballMachine gm) {
		System.out.println("잠깐만 기다려 주세요. 알맹이가 나가고 있습니다");
	}
	public void ejectQuarter(GumballMachine gm) {
		System.out.println("이미 알맹이를 뽑으셨습니다.");
	}
	public boolean turnCrank(GumballMachine gm) {
		System.out.println("손잡이는 한 번만 돌려주세요.");
		return false;
	}
	public abstract void dispense(GumballMachine gm);
}
