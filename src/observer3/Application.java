package observer3;

import observer3.Observable.Observer;

public class Application {

	public static void main(String[] args) {
		// 1. Observable�� ���׸����� ����
		// 2. ��������Ʈ
		// 3. ���ο� Observer(Interface)�� �ִ´�
		Button button = new Button();
		
		button.addObserver(new Observer<String>() {
			
			@Override
			public void update(Observable<String> o, String arg) {
				// TODO Auto-generated method stub
				System.out.println(o+"is clicked");
			}
		});
		
		button.onClick();
		button.onClick();
		button.onClick();
	}
}
