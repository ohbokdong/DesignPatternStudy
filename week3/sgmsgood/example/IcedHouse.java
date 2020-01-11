package PensionReserve;

public class IcedHouse extends Pension {
	public IcedHouse() {
		description = "이색 체험! 이글루의 매력을 직접 경험해보세요.";
	}
	
	@Override
	public int cost() {
		return 200000;
	}
}
