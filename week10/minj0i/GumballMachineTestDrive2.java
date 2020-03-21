package week10.minj0i;

public class GumballMachineTestDrive2 {
	public static void main(String[] args) {
		GumballMachine2 gumballMachine = new GumballMachine2(5);
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		
		System.out.println(gumballMachine);
		
	}
}
