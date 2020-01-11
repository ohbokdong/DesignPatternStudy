package week3.younggeun0.example;

public class DoubleDamage extends Enchant {

	Weapon weapon;
	
	public DoubleDamage(Weapon weapon) {
		this.weapon = weapon;
	}
	
	@Override
	public String getName() {
		// 같은 Weapon을 상속받기 때문에 getName 시 null이 나옴
		// 때문에 멤버의 name을 반환하도록 override 처리를 해줘야 함
		return weapon.getName();
	}
	
	@Override
	public String getDescription() {
		return weapon.getDescription() + "+딜량 두배";
	}
	
	@Override
	public double damage() {
		return weapon.damage() * 2;
	}
}
