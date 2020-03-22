package week10.younggeun0.state.staticway;

public class GumballMachineTestDrive {
	public static void main(String[] args) {
		
		GumballMachine gm = new GumballMachine(5);
		GumballMachine gm1 = new GumballMachine(5);
		System.out.println(gm);
		
		gm.insertQuarter();
		gm.turnCrank();
		
		System.out.println(gm);
		
		gm.insertQuarter();
		gm.turnCrank();
		gm.insertQuarter();
		gm.turnCrank();
		
		System.out.println(gm);
	}
}
