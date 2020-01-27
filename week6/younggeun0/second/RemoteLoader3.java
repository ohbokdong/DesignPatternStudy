package week6.younggeun0.second;

import week6.younggeun0.first.Command;

public class RemoteLoader3 {
	public static void main(String[] args) {
		Light light = new Light("Living Room ");
		Stereo stereo = new Stereo("Living Room ");
		
		LightOnCommand2 lightOn = new LightOnCommand2(light);
		LightOffCommand lightOff = new LightOffCommand(light);
		StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		
		Command[] partyOn = { lightOn, stereoOn };
		Command[] partyOff = { lightOff, stereoOff };
		
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffCommand = new MacroCommand(partyOff);
		
		RemoteControl rc = new RemoteControl();
		
		rc.setCommand(0, partyOnMacro, partyOffCommand);
		
		System.out.println("--- Pushing Macro On ---");
		rc.onButtonWasPushed(0); // Light, Stereo On을 한번에 
		
		System.out.println("--- Pushing Macro Off ---");
		rc.offButtonWasPushed(0); // Light, Stereo Off를 한번에
	}
}
