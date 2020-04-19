package week11.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote{
	public String sayHello() throws RemoteException;
}
