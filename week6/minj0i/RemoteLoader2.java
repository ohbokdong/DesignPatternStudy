package week6.minj0i;

public class RemoteLoader2 {
	public static void main(String[] args) {
		RemoteControlWithUndo remoteContorl = new RemoteControlWithUndo();
		
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		
		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
		
		remoteContorl.setCommand(0, ceilingFanMedium, ceilingFanOff);
		remoteContorl.setCommand(1, ceilingFanHigh, ceilingFanOff);
		
		remoteContorl.onButtonWasPushed(0);
		remoteContorl.offButtonWasPushed(0);
		System.out.println(remoteContorl);
		remoteContorl.undoButtonWasPushed();
		
		remoteContorl.onButtonWasPushed(1);
		System.out.println(remoteContorl);
		remoteContorl.undoButtonWasPushed();
	}
}
