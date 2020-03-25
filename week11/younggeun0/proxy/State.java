package week11.younggeun0.proxy;

import java.io.Serializable;

public interface State extends Serializable {
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
