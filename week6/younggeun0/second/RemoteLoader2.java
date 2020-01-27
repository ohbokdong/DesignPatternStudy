package week6.younggeun0.second;

public class RemoteLoader2 {
	
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl();
		
		CeilingFan ceilingFan = new CeilingFan("Living Room ");
		
		CeilingFanHighCommand cfhc = new CeilingFanHighCommand(ceilingFan);
		CeilingFanMediumCommand cfmc = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanOffCommand cfoc = new CeilingFanOffCommand(ceilingFan);
		
		rc.setCommand(0, cfhc, cfoc);
		rc.setCommand(1, cfmc, cfoc);
		
		rc.onButtonWasPushed(0);
		rc.offButtonWasPushed(0);
		
		System.out.println(rc);
		rc.undoButtonWasPushed();
		
		rc.onButtonWasPushed(1);
		
		System.out.println(rc);
		
		rc.undoButtonWasPushed();
	}
}
