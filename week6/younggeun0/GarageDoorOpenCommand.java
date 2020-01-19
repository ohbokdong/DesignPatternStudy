package week6.younggeun0;

public class GarageDoorOpenCommand implements Command {
	GarageDoor gd;
	
	public GarageDoorOpenCommand(GarageDoor gd) {
		this.gd = gd;
	}
	
	@Override
	public void execute() {
		gd.up();
		gd.lightOn();
	}
}
