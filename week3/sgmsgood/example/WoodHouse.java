package PensionReserve;

public class WoodHouse extends Pension{
	public WoodHouse() {
		description = "나무로 된 집은 따뜻함과 안정감을 줍니다.";
	}
	
	@Override
	public int cost() {
		return 130000;
	}
}
