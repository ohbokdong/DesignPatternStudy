package week11.proxy;

import java.rmi.*;

public class GumballMonitor {
	GumballMachineRemote machine;
	
	public GumballMonitor(GumballMachineRemote machine) {
		this.machine = machine;
	}
	
	public void report() {
		try {
			System.out.println("뽑기 기계 위치 : " + machine.getLocation());
			System.out.println("현재 재고 : " + machine.getCount());
			System.out.println("현재 상태 : " + machine.getState());
		} catch (RemoteException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
