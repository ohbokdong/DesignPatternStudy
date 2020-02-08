package week6.minj0i;

public class GarageDoorUpCommand implements Command{
	GarageDoor garageDoor;

	public GarageDoorUpCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}
	
	@Override
	public void execute() {
		garageDoor.on();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
