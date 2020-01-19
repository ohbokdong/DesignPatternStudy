package week6.younggeun0;

public class RemoteControlTest { // 커맨드 패턴 클라인트에 해당하는 부분
	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl(); // remote변수가 인보커(Invoker)역할
		
		Light light = new Light(); // 요청을 받아서 처리할 리시버(Receiver)인 Light객체를 생성 
		GarageDoor garageDoor = new GarageDoor();
		LightOnCommand lightOn = new LightOnCommand(light); // 커맨드 객체를 생성, 이 때 리시버를 전달
		GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
		
		remote.setCommand(lightOn); // 커맨드 객체를 인보커한테 전달
		remote.buttonWasPressed(); 
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();
	}
}
