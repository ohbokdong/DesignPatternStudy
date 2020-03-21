package week10.younggeun0.state.staticway;

public interface State {
	public void insertQuarter(GumballMachine gm);
	public void ejectQuarter(GumballMachine gm);
	public void turnCrank(GumballMachine gm);
	public void dispense(GumballMachine gm);
}
