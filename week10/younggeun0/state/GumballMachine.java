package week10.younggeun0.state;

public class GumballMachine {
	// 네 가지 상태
	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;
	
	int state = SOLD_OUT; // 상태 초기화
	int count = 0;
	
	public GumballMachine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}
	
	public void insertQuarter() { // 행동을 메소드로 구현, 동전이 투입된 경우
	    if (state == HAS_QUARTER) {
	        System.out.println("동전은 한 개만 넣어주세요.");
	    } else if (state == NO_QUARTER) {
	    	state = HAS_QUARTER;
	    	System.out.println("동전을 넣으셨습니다.");
	    } else if (state == SOLD_OUT) {
	        System.out.println("매진되었습니다. 다음 기회에 이용해주세요.");
	    } else if (state == SOLD) {
	        System.out.println("잠깐만 기다려주세요. 알맹이가 나오고 있습니다.");
	    }
	}
	
	public void ejectQuarter() { // 사용자가 동전을 반환 받으려고 하는 경우
	    if (state == HAS_QUARTER) {
	        System.out.println("동전이 반환됩니다.");
	        state = NO_QUARTER;
	    } else if (state == NO_QUARTER) {
	    	System.out.println("동전을 넣어주세요.");
	    } else if (state == SOLD_OUT) {
	        System.out.println("동전을 넣지 않으셨습니다. 동전이 반환되지 않습니다.");
	    } else if (state == SOLD) {
	        System.out.println("이미 알맹이를 뽑으셨습니다.");
	    }
	}
	
	public void turnCrank() { // 손잡이를 돌리는 경우
	    if (state == HAS_QUARTER) {
	        System.out.println("손잡이를 돌리셨습니다.");
	        state = SOLD;
	        dispense();
	    } else if (state == NO_QUARTER) {
	    	System.out.println("동전을 넣어주세요.");
	    } else if (state == SOLD_OUT) {
	        System.out.println("매진되었습니다.");
	    } else if (state == SOLD) {
	        System.out.println("손잡이를 한 번만 돌려주세요.");
	    }
	}
	
	public void dispense() { // 알맹이 꺼내기
	    if (state == HAS_QUARTER) {
	    	System.out.println("알맹이가 나갈 수 없습니다.");
	    } else if (state == NO_QUARTER) {
	    	System.out.println("동전을 넣어주세요.");
	    } else if (state == SOLD_OUT) {
	        System.out.println("매진입니다.");
	    } else if (state == SOLD) {
	        System.out.println("알맹이가 나가고 있습니다.");
	        count--;
	        if (count == 0) {
	        	System.out.println("더 이상 알맹이가 없습니다.");
	        	state = SOLD_OUT;
	        } else {
	        	state = NO_QUARTER;
	        }
	    }
	}
	
	@Override
	public String toString() {
		String result = "\n남은 개수 : "+count+", state : ";
	
	   if (state == HAS_QUARTER) {
		   result = result + "동전 있음\n";
	    } else if (state == NO_QUARTER) {
	    	result = result + "동전 없음\n";
	    } else if (state == SOLD_OUT) {
	    	result = result + "완판\n";
	    } else if (state == SOLD) {
	    	result = result + "판매중\n";
	    }
		
		return result;
	}
}
