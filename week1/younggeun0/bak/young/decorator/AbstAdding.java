package decorator;

public class AbstAdding implements IBeverage {
	
	private IBeverage base;
	
	public AbstAdding(IBeverage base) {
		super();
		this.base = base; // ���Ͻ�
	}
	
	@Override
	public int getTotalPrice() {
		return base.getTotalPrice();
	}
	
	public IBeverage getBase() {
		return base;
	}
}
