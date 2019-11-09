package strategy_review0525;

public class Character {
	
	// ������
	private Weapon weapon;
	
	// ��ȯ ����
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void attack() {
		if (weapon == null) {
			System.out.println("�Ǽ� ����!");
		} else {
			weapon.attack(); // ����(delegate)
		}
	}

}
