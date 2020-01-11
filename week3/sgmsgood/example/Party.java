package PensionReserve;

public class Party extends Activity {
	Pension pension;
	
	public Party(Pension pension) {
		this.pension = pension;
	}
	
	@Override
	public String getDescription() {
		return pension.getDescription() + "w/ Party\n";
	}
	
	@Override
	public int cost() {
		return 70000 + pension.cost();
	}
}
