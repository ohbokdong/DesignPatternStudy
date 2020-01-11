package week3.younggeun0.example;

public class ShortSword extends Weapon {
	
	public ShortSword() {
		setName("단검");
		setDescription("일반 단검");
	}
	
	@Override
	public double damage() {
		return 5;
	}
}
