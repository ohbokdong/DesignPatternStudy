package bridge;

public class PrintMorseCode extends MorseCode {

	public PrintMorseCode(MorseCodeFunction function) {
		super(function);
	}
	
	// 원래 모든 단어를 구현해야 하지만 garam만 출력할 수 있게 만듦
	public PrintMorseCode g() {
		dash();dash();dot();space();
		return this;
	}
	public PrintMorseCode a() {
		dot();dash();space();
		return this;
	}
	public PrintMorseCode r() {
		dot();dash();dot();space();
		return this;
	}
	public PrintMorseCode m() {
		dash();dash();space();
		return this;
	}
}
