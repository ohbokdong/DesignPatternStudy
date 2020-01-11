package PensionReserve;

public class Fishing extends Activity {
	Pension pension;
	
	public Fishing(Pension pension) {
		this.pension = pension;
	}
	
	@Override
	public String getDescription() {
		return pension.getDescription() + "w/ Fishing\n";
	}
	
	@Override
	public int cost() {
		return 30000 + pension.cost();
	}
}
