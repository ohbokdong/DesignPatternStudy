package week6.minj0i;

public class StereoOffCommand implements Command {
	
	Stereo stereo;
	
	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.off();
	}
	
	@Override
	public void undo() {
		stereo.on();
	}
}
