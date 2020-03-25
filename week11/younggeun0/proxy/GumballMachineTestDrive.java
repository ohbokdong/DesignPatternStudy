package week11.younggeun0.proxy;

import java.rmi.Naming;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		int count = 0;
		
		if (args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(1);
		}
		
		try {
			count = Integer.parseInt(args[1]);
			GumballMachine gumballMachine = new GumballMachine(count, args[0]);
			Naming.rebind("//"+args[0]+"/gumballmachine", gumballMachine);
//			GumballMonitor monitor = new GumballMonitor(gumballMachine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 기타 코드
//		monitor.report();
	}
}
