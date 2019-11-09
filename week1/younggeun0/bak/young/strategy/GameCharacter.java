package strategy;

public class GameCharacter {

	// ������
	private Weapon weapon;
	
	// ��ȯ ����
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void attack() {
		
		if (weapon == null) {
			System.out.println("�Ǽ� ����");
		} else {
			// ��������Ʈ
			weapon.attack();
		}
	}
}
