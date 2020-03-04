package week1.strategy;

public class MiniDuckSimulator {

	public static void main(String[] args) {

		Duck mallard = new MallardDuck();
		mallard.display();
		mallard.swim();
		mallard.performFly();
		mallard.performQuack();

		System.out.println();

		Duck model = new ModelDuck();
		model.display();
		model.swim();
		model.performFly();
		model.performQuack();
		System.out.println("모형 오리 나는 행동 수정");
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

		System.out.println();

		Duck rubber = new RubberDuck();
		rubber.display();
		rubber.swim();
		rubber.performFly();
		rubber.performQuack();

		System.out.println();

		Duck redhead = new RedheadDuck();
		redhead.display();
		redhead.swim();
		redhead.performFly();
		redhead.performQuack();

		System.out.println();

		Duck decoy = new DecoyDuck();
		decoy.display();
		decoy.swim();
		decoy.performFly();
		decoy.performQuack();



	} // main

} // class
