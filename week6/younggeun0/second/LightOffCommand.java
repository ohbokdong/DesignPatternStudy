package week6.younggeun0.second;

import week6.younggeun0.first.Command;

public class LightOffCommand implements Command {

	Light light;
	
    public LightOffCommand(Light light) {
    	this.light = light;
	}
	
	@Override
	public void execute() {
		light.off();
	}
	
	@Override
	public void undo() {
		light.on();
	}
}
