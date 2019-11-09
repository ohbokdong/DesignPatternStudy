package cor2;

public class Armor implements Defense {
	
	private Defense nextDefense;
	private int def;
	
	public Armor() {
		
	}
	
	public Armor(int def) {
		this.def = def;
	}
	
	
	public void setDef(int def) {
		this.def = def;
	}

	@Override
	public void defense(Attack attack) {
		
		/*
		 * Point!
		 * 처리결과와 관계없이 다음을 처리를 하도록 구현 가능
		 * 즉, 책임 사슬 패턴에선 하나의 객체만 책임을 지지 않아도 됨
		 */
		process(attack);
		
		if (nextDefense != null) {
			nextDefense.defense(attack);
		}
	}
	
	private void process(Attack attack) {
		int amount = attack.getAmount();
		amount -= def;
		attack.setAmount(amount);
	}

	public void setNextDefense(Defense nextDefense) {
		this.nextDefense = nextDefense;
	}
}
