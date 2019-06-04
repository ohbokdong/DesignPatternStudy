package bridge;

public class Main {

	public static void main(String[] args) {
		
		// PrintMorseCode code = new PrintMorseCode(new DefaultMorseCodeFunction());
		// 다른 방식으로 바꾼다면 MorseCodeFunction을 구현한 클래스로 바꿔주기만 하면 됨
		PrintMorseCode code = new PrintMorseCode(new SoundMorseCodeFunction());
		
		// 체이닝
		code.g().a().r().a().m();
	}
}
