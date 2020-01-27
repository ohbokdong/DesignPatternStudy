package week6.younggeun0.second;

import week6.younggeun0.first.Command;

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
