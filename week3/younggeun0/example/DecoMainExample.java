package week3.younggeun0.example;

public class DecoMainExample {
	
	public static void main(String[] args) {
		Weapon weapon1 = new LongSword();
		System.out.println("------------"+weapon1.getName()+" 강화 전"+"------------");
		System.out.println(weapon1.getDescription());
		System.out.println(weapon1.damage());

		weapon1 = new DoubleDamage(weapon1);
		System.out.println("------------"+weapon1.getName()+" 강화 후"+"------------");
		System.out.println(weapon1.getDescription());
		System.out.println(weapon1.damage());
		
		Weapon weapon2 = new ShortSword();
		System.out.println("------------"+weapon2.getName()+" 강화 전"+"------------");
		System.out.println(weapon2.getDescription());
		System.out.println(weapon2.damage());

		weapon2 = new DoubleDamage(weapon2);
		weapon2 = new AlwaysCriticalDamage(weapon2);
		System.out.println("------------"+weapon2.getName()+" 강화 후"+"------------");
		System.out.println(weapon2.getDescription());
		System.out.println(weapon2.damage());
	}
}
