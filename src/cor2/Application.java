package cor2;

public class Application {

	public static void main(String[] args) {
		
		Attack attack = new Attack(100);
		
		Armor armor1 = new Armor(10); // 예로 갑옷
		Armor armor2 = new Armor(15); // 예로 투구
		
		armor1.setNextDefense(armor2);
		// 첫번째 공격
		armor1.defense(attack);
		
		System.out.println(attack.getAmount());
		
		/*
		 * Point2
		 * 책임 사슬 패턴을 사용하면 
		 * 동적으로 방어구를 추가할 수 있음
		 * 동적으로 책임사슬에 추가할 수 있다
		 */
		Defense defense = new Defense() {
			
			@Override
			public void defense(Attack attack) {
				int amount = attack.getAmount();
				attack.setAmount(amount-=50);
			}
		};
		
		// 예로 방어구 추가 착용
		armor2.setNextDefense(defense);
		
		attack.setAmount(100);
		// 두번째 공격
		armor1.defense(attack);
		
		System.out.println(attack.getAmount());
	}
}
