package week10.younggeun0.state;

public class GumballMachineTestDrive2 {

	public static void main(String[] args) {
		GumballMachine2 gm = new GumballMachine2(5);
		
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
