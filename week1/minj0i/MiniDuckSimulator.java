package week1.minj0i;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		//행동 세터 메소드가 호출
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
