package observer3;

import observer3.Observable.Observer;

public class Application {

	public static void main(String[] args) {
		// 1. Observable을 제네릭으로 변경
		// 2. 델리게이트
		// 3. 내부에 Observer(Interface)를 넣는다
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
