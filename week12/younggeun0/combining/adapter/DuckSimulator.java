package week12.younggeun0.combining.adapter;

public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		simulator.simulate();
	}

	void simulate() {
		Quackable mallardDuck = new MallardDuck();
		Quackable redheadDuck = new RedheadDuck();
		Quackable duckCall = new DuckCall();
		Quackable rubberDuck = new RubberDuck();
		
		// 어댑터 패턴으로 덕처럼 거위 사용
		Quackable gooseDuck = new GooseAdapter(new Goose());
 
		System.out.println("\nDuck Simulator: With Goose Adapter");
 
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseDuck);
	}
 
	void simulate(Quackable duck) {
		duck.quack();
	}
}
