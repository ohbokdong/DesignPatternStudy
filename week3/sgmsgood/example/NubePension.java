package PensionReserve;

public class NubePension {
 public static void main(String[] args) {
	 
	 Pension pension = new WoodHouse();
	 pension = new Spa(pension);
	 pension = new Fishing(pension);
	 System.out.println(pension.getDescription() + "\n" + pension.cost());
 }
}
