package Command;

public class RemoteLoader {
	public static void main(String[] args) {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		Stereo stereo = new Stereo ("Living Room");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand (livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand (kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand (kitchenLight);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
		
		remoteControl.setCommand(0, ceilingFanHigh, ceilingFanOff);
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand (stereo);
		StereoOffCommand stereoOff = new StereoOffCommand (stereo);
		
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(2, stereoOnWithCD, stereoOff);
		remoteControl.setCommand(3, ceilingFanHigh, ceilingFanOff);
		
		System.out.println(remoteControl);
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		
		System.out.println("--------------------------");
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		
		System.out.println("--------------------------");
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(3);
		remoteControl.onButtonWasPushed(3);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		
	}
}
