package mediator;

public class ChatMediator extends Mediator {

	@Override
	public void mediate(String data) {
		for (Colleague colleague : colleagues) {
			// ���� ���ɼ� ������ �����ϸ� ���⼭ ó��
			colleague.handle(data);
		}
	}
}
