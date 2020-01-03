package week1;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		Duck model = new ModelDuck();

		mallard.performQuack();
		mallard.performFly();
		
		model.performQuack();
		model.performFly();
		
		// 실행 중 오리의 행동을 바꾸고 싶으면 원하는 행동에 해당하는
		// DUCK의 세터 메소드를 호출하기만 하면 됨.
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	} // main

} // class
