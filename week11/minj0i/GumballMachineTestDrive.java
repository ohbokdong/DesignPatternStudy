package week11.minj0i;

import java.rmi.Naming;

public class GumballMachineTestDrive {
	public static void main(String[] args) {
		int count = 0;
		
		if(args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(1);
		}
		
		try {
			count = Integer.parseInt(args[1]);
			GumballMachine gumballMachine = new GumballMachine(args[0], count);
			
			Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
			//GumballMonitor monitor = new GumballMonitor(gumballMachine);
			//monitor.report();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
