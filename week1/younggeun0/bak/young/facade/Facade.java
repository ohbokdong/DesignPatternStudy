package facade;

public class Facade {

	private HelpSystem1 helpSystem1;
	private HelpSystem2 helpSystem2;
	private HelpSystem3 helpSystem3;
	
	public Facade() {
		// 어떤 Facade를 호출하면 해당 시스템을 생성
		helpSystem1 = new HelpSystem1();
		helpSystem2 = new HelpSystem2();
		helpSystem3 = new HelpSystem3();
	}
	
	public void process() {
		// 프로세스 실행하면 서브시스템들을 수행 
		helpSystem1.process();
		helpSystem2.process();
		helpSystem3.process();
	}
}
