package mediator;

public class ChatMediator extends Mediator {

	@Override
	public void mediate(String data) {
		for (Colleague colleague : colleagues) {
			// 중재 가능성 정보가 존재하면 여기서 처리
			colleague.handle(data);
		}
	}
}
