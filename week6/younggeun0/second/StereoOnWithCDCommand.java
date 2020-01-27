package week6.younggeun0.second;

import week6.younggeun0.first.Command;

public class StereoOnWithCDCommand implements Command {
	
	Stereo stereo;
	
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume(11);
	}
	
	@Override
	public void undo() {
		stereo.off();
	}
}
