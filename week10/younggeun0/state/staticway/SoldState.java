package week10.younggeun0.state.staticway;

public class SoldState extends State {
	@Override
	public void dispense(GumballMachine gm) {
		gm.releaseBall();
		if (gm.getCount() > 0) {
			gm.setState(StaticState.noQuarterState);
		} else {
			System.out.println("Opps, 다 팔렸네");
			gm.setState(StaticState.soldOutState);
		}
	}
}
