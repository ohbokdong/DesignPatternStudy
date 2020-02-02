package Singleton;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	//이 코드는 보일러가 비어있을 때만 돌아갑니다.
	public ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public void fill() {
		// 보일러가 비어있을 때만 재료를 집어 넣습니다. 
		// 원료를 가득 채우고 나면 empty와 boiled 플래그를 false로 설정합니다. 
		if(isEmpty()) {
			empty = false;
			boiled = false;
			//보일러에 우유/초콜릿을 혼합한 재료를 집어넣음
		}
	}
	
	public void drain() {
		// 보일러가 가득 차있고, 다 끓여진 상태에서만 보일러에 들어있는 재료를 다음 단계로 넘깁니다.
		// 보일러를 다 비우고 나면 empty 플래그를 다시 true로 설정합니다.
		if(!isEmpty() && isBoiled()) {
			// 끓인 재료를 다음 단계로 넘김
			empty = true;
		}
	}
	
	public void boil() {
		if(!isEmpty() && isBoiled()) {
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