package PensionReserve;

public class StoneHouse extends Pension{
	
	public StoneHouse() {
		description = "고급 대리석으로 꾸며진 방으로 럭셔리한 삶을 경험하세요.";
	}
	
	@Override
	public int cost() {
		return 150000;
	}
}
