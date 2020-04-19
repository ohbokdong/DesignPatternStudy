package week11.proxy;

import java.rmi.Naming;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachine gumballMachine = null;
		int count;
		if (args.length < 2) {
			System.out.println("Please Enter the GumballMachine <name> <inventory>");
			System.exit(1);
		} 
		
		try {
			count = Integer.parseInt(args[1]);
			gumballMachine = new GumballMachine(args[0], count);
			Naming.rebind("rmi://172.30.1.12:8080/"+args[0]+"/gumballMachine", gumballMachine);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		} // end catch
	}

}
