package week7.minj0i;

public class DuckTestDrive {
	
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck(); //duck 생성
		
		WildTurkey turkey = new WildTurkey(); //turkey 생성
		Duck turkeyAdapter = new TurkeyAdapter(turkey); //turkey를 TurkeyAdapter로 감싸서 duck으로 보이게 함
		
		//turkey 자체 테스트
		System.out.println("The turkey says...");
		turkey.gobble();
		turkey.fly();
		
		//duck객체 테스트
		System.out.println("\nThe Duck says...");
		testDuck(duck);
		
		//가장 중요한 부분! duck대신 turkey를 전달
		System.out.println("\nThe TurkeyAdapter says...");
		testDuck(turkeyAdapter);
	}
	
	//오리 객체를 받아서 아래 메소드들을 호출
	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
	
}
