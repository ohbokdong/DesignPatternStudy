package week1.minj0i.example;

public class PeopleSimulator {
	public static void main(String[] args) {
		People jungyun = new JungYun();
		jungyun.performEat();
		jungyun.performSleep();
		
		People younggeun = new YoungGeun();
		younggeun.performEat();
		//갑자기 낮밤이 바뀌어버림
		younggeun.setSleepBehavior(new SleepAtMorning());
		younggeun.performSleep();
	}
}
