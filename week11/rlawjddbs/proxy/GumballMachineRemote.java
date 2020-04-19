package week11.proxy;

import java.rmi.RemoteException;

public interface GumballMachineRemote {
	public int getCount() throws RemoteException;
	public String getLocation() throws RemoteException;
	public State getState() throws RemoteException;
} // interface
