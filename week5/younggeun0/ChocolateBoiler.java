package week5.younggeun0;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	
///////////////////////////////// 싱글턴 전 	
	public ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
////////////////////////////////////////////

///////////////////////////////// 싱글턴 적용 후
//	private static ChocolateBoiler chocolateBoiler;
//	private ChocolateBoiler() {
//		empty = true;
//		boiled = false;
//	}
//	public static ChocolateBoiler getInstance() {
//		if (chocolateBoiler == null) {
//			chocolateBoiler = new ChocolateBoiler();
//		}
//		
//		return chocolateBoiler;
//	}
////////////////////////////////////////////////////////
	
	public void fill() {
		if (isEmpty()) {
			System.out.println("초콜릿 채우기");
			empty = false;
			boiled = false;
			// 보일러에 우유/초콜릿 혼합한 재료를 집어 넣음
		}
	}
	
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			System.out.println("끓인 재료를 드레인");
			// 끓인 재료를 다음 단계로 넘김
			empty = true;
		}
	}
	
	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			System.out.println("초콜릿 끓이기");
			// 재료를 끓임
			boiled = true;
		}
	}
	
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isBoiled() {
		return boiled;
	}

}
