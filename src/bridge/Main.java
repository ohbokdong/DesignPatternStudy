package bridge;

public class Main {

	public static void main(String[] args) {
		
		// PrintMorseCode code = new PrintMorseCode(new DefaultMorseCodeFunction());
		// �ٸ� ������� �ٲ۴ٸ� MorseCodeFunction�� ������ Ŭ������ �ٲ��ֱ⸸ �ϸ� ��
		PrintMorseCode code = new PrintMorseCode(new SoundMorseCodeFunction());
		
		// ü�̴�
		code.g().a().r().a().m();
	}
}
