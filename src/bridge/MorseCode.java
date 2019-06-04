package bridge;

public class MorseCode {
	
	private MorseCodeFunction function;
	
	public MorseCode(MorseCodeFunction function) {
		this.function = function;
	}

	public void setFunction(MorseCodeFunction function) {
		this.function = function;
	}
	
	public void dot() {
		function.dot(); // 위임으로 처리
	}
	public void dash() {
		function.dash();
	}
	public void space() {
		function.space();
	}
}
