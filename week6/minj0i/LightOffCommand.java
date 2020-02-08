package week6.minj0i;

public class LightOffCommand implements Command{
	Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		
	}
}
