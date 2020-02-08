package week6.minj0i;

public class RemoteLoader3 {
	public static void main(String[] args) {
		Light light = new Light("Living Room ");
		Stereo stereo = new Stereo("Living Room ");
		
		LightOnCommand lightOn = new LightOnCommand(light);
		LightOffCommand lightOff = new LightOffCommand(light);
		StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		
		Command[] partyOn = { lightOn, stereoOn };
		Command[] partyOff = { lightOff, stereoOff };
		
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffCommand = new MacroCommand(partyOff);
		
		RemoteControl remoteControl = new RemoteControl();
		
		remoteControl.setCommand(0, partyOnMacro, partyOffCommand);
		
		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On ---");
		remoteControl.onButtonWasPushed(0);
		System.out.println("--- Pushing Macro Off ---");
		remoteControl.offButtonWasPushed(0);
	}
}