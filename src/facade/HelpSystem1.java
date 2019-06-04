package facade;

class HelpSystem1 { // default, package내에서만 접근 가능

	// 굉장한 복잡한 코드라 가정
	public HelpSystem1() {
		System.out.println("Call Constructor : " + getClass().getSimpleName());
	}
	
	public void process() {
		System.out.println("Call Process" + getClass().getSimpleName());
	}
}
