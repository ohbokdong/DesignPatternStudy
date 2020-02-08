package week6.minj0i;

public class CeilingFanOffCommand implements Command {
	CeilingFan ceilingfan;

	public CeilingFanOffCommand(CeilingFan ceilingfan) {
		this.ceilingfan = ceilingfan;
	}
	
	@Override
	public void execute() {
		ceilingfan.off();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
