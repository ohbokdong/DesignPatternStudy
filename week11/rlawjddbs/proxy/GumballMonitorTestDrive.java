package week11.proxy;

import java.rmi.Naming;

public class GumballMonitorTestDrive {

	public static void main(String[] args) {
		String[] location = {"rmi://172.30.1.12:8080/santafe/gumballMachine",
				"rmi://172.30.1.12:8080/boulder/gumballMachine",
				"rmi://172.30.1.12:8080/seattle/gumballMachine"};
		GumballMonitor[] monitor = new GumballMonitor[location.length];
		
		for(int i = 0; i < location.length; i++) {
			try {
				GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			} // end catch
		} // end for
		
		for (int i=0; i < monitor.length; i++) {
			monitor[i].report();
		} // end for
	} // main

}
