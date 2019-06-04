package mediator;

public class Application {

	public static void main(String[] args) {
		Mediator mediator = new ChatMediator();
		
		Colleague colleague1 = new ChatColleague();
		Colleague colleague2 = new ChatColleague();
		Colleague colleague3 = new ChatColleague();
		
		// ������(mediator)���� colleague���� ������ ��Ŵ
		colleague1.join(mediator);
		colleague2.join(mediator);
		colleague3.join(mediator);
		
		// colleague�� �����͸� ������ �ٽ� �������� ���۽�Ŵ
		colleague1.sendData("AAA");
		colleague1.sendData("BBB");
		colleague1.sendData("CCC");
	}
}
