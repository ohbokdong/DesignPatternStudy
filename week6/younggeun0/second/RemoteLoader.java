package week6.younggeun0.second;

public class RemoteLoader {
	
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl();
		
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		Stereo stereo = new Stereo("Living Room");
		
		LightOnCommand2 livingRoomLightOn = new LightOnCommand2(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		
		StereoOnWithCDCommand sdwcdc = new StereoOnWithCDCommand(stereo);
		StereoOffCommand soc = new StereoOffCommand(stereo);
		
		rc.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		rc.setCommand(1, sdwcdc, soc);
		
		System.out.println(rc);
		
		rc.onButtonWasPushed(0);
		rc.offButtonWasPushed(0);
		
		System.out.println("----undo!----");
		rc.undoCommand.undo();
		System.out.println("-------------");
		
		rc.onButtonWasPushed(1);
		rc.offButtonWasPushed(1);
		
		rc.onButtonWasPushed(2);
		rc.offButtonWasPushed(2);
		
		rc.undoCommand.undo();
	}
}
