package PensionReserve;

public class StoneHouse extends Pension{
	
	public StoneHouse() {
		description = "��� �븮������ �ٸ��� ������ ���Ÿ��� ���� �����ϼ���.";
	}
	
	@Override
	public int cost() {
		return 150000;
	}
}
