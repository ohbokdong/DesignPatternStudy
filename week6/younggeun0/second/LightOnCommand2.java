package week6.younggeun0.second;

import week6.younggeun0.first.Command;

public class LightOnCommand2 implements Command {
	public Light light;
	
	public LightOnCommand2(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.on();
	}
	
	@Override
	public void undo() {
		light.off();
	}
}
