package proxy;

public class Proxy implements Subject {
	
	private Subject real;
	
	public Proxy(Subject real) {
		this.real = real;
	}

	@Override
	public void action1() {
		System.out.println("간단한 업무 by 프록시");
	}
	
	@Override
	public void action2() {
		// Proxy가 할 수 없는 업무는 위임
		this.real.action2();
	}
}
