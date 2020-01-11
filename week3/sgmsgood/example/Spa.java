package PensionReserve;

public class Spa extends Activity {
	Pension pension;
	
	public Spa(Pension pension) {
		this.pension = pension;
	}
	
	@Override
	public String getDescription() {
		return pension.getDescription() + "w/ Spa \n";
	}
	
	@Override
	public int cost() {
		return 50000 + pension.cost();
	}
}
