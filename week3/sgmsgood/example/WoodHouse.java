package PensionReserve;

public class WoodHouse extends Pension{
	public WoodHouse() {
		description = "������ �� ���� �����԰� �������� �ݴϴ�.";
	}
	
	@Override
	public int cost() {
		return 130000;
	}
}
