package week14.memento;

public class GameDemo {

	public static void main(String[] args) {
		MasterGameObject mgo = new MasterGameObject();
		CareTaker careTaker = new CareTaker();
		
		// 레벨업 하면서 가끔씩 중간 세이브를 하는 상태
		mgo.setState("레벨업 - 레벨 7");
		mgo.setState("레벨업 - 레벨 8");
		careTaker.add(mgo.saveState());
		
		mgo.setState("레벨업 - 레벨 9");
		careTaker.add(mgo.saveState());
		
		mgo.setState("레벨업 - 레벨 10");
		System.out.println("현재 게임 상태... " + mgo.getCurrentState());
		
		// 죽음
		mgo.setState("죽음 - 레벨 0");
		System.out.println("현재 게임 상태... " + mgo.getCurrentState());
		
		// 가장 마지막에 저장된 시점으로 복구
		mgo.restoreState(careTaker.get(careTaker.getLastSavedIdx()));
		System.out.println("현재 게임 상태... " + mgo.getCurrentState());
	}

}
