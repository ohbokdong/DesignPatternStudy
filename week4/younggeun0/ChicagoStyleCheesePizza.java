package week4.younggeun0;

public class ChicagoStyleCheesePizza extends Pizza{
	public ChicagoStyleCheesePizza() {
		setName("시카고스타일 치즈 피자");
		setDough("두꺼운 크러스트 도우");
		setSause("토마토 소스");
		
		toppings.add("갈린 모짜렐라 치즈");
	}
	
	void cut() {
		System.out.println("시카고풍이니 사각형으로 자른다...");
	}
}
