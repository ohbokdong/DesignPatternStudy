package bridge;

public class SoundMorseCodeFunction implements MorseCodeFunction {

	@Override
	public void dot() {
		System.out.print("»ä");
	}
	@Override
	public void dash() {
		System.out.print("»ß~");
	}
	@Override
	public void space() {
		System.out.print(" ");
	}
}
