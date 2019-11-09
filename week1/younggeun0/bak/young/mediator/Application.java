package mediator;

public class Application {

	public static void main(String[] args) {
		Mediator mediator = new ChatMediator();
		
		Colleague colleague1 = new ChatColleague();
		Colleague colleague2 = new ChatColleague();
		Colleague colleague3 = new ChatColleague();
		
		// 중재자(mediator)에게 colleague들이 조인을 시킴
		colleague1.join(mediator);
		colleague2.join(mediator);
		colleague3.join(mediator);
		
		// colleague가 데이터를 보내면 다시 각각에게 전송시킴
		colleague1.sendData("AAA");
		colleague1.sendData("BBB");
		colleague1.sendData("CCC");
	}
}
