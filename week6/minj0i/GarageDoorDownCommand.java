package week6.minj0i;

public class GarageDoorDownCommand implements Command{
	GarageDoor garageDoor;

	public GarageDoorDownCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}
	
	@Override
	public void execute() {
		garageDoor.off();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
