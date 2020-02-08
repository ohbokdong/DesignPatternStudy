package week6.minj0i;


public class StereoOnWithCDCommand implements Command{
	Stereo stereo;
	
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	public void execute() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
