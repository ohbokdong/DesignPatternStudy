package week6.minj0i;

public class CeilingFanOnCommand implements Command{
	CeilingFan ceilingfan;

	public CeilingFanOnCommand(CeilingFan ceilingfan) {
		this.ceilingfan = ceilingfan;
	}
	
	@Override
	public void execute() {
		ceilingfan.on();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
	
	
}
