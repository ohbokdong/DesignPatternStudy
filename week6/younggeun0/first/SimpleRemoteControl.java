package week6.younggeun0.first;

public class SimpleRemoteControl {
	Command slot;
	
	public SimpleRemoteControl() { }
	
	public void setCommand(Command command) {
		slot = command;
	}
	
	public void buttonWasPressed() {
		slot.execute();
	}
}
