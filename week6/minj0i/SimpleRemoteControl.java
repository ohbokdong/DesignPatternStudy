package week6.minj0i;

public class SimpleRemoteControl {
	Command slot;
	
	public SimpleRemoteControl() {}
	
	public void setCommand(Command command) {
		slot = command;
	}
	
	public void buttonWasPressend() {
		slot.execute();
	}
}
