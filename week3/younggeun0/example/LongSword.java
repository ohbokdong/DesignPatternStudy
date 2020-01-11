package week3.younggeun0.example;

public class LongSword extends Weapon {
	
	public LongSword() {
		setName("롱소드");
		setDescription("일반 롱소드");
	}
	
	@Override
	public double damage() {
		return 10;
	}
}
