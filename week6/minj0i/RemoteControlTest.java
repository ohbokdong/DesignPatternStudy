package week6.minj0i;

public class RemoteControlTest {
	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light(null);
		LightOnCommand lightOn = new LightOnCommand(light);
		
		remote.setCommand(lightOn);
		remote.buttonWasPressend();
	}
}
