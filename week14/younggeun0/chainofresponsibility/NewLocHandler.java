package week14.younggeun0.chainofresponsibility;

public class NewLocHandler extends Handler {
	private String strText;
	public NewLocHandler(String strText) {
		this.strText = strText;
	}
	
	@Override
	public void handleRequest() {
		if (strText.indexOf("설치") != -1 || strText.indexOf("신규") != -1) {
			System.out.println("***************************");
			System.out.println("=>신규 설치 요청 메일로 분류되었습니다.");
			System.out.println("\n");
			/* 
			 * 여기서 영업 부서로 포워딩 처리
			 */
		} else {
			System.out.println("***************************");
			System.out.println("=>처리할 수 없는 메일입니다.");
			System.out.println("\n");
			/*
			 * 사슬 맨 끝에간 분류되지 않은 메일을 처리하는 로직을 여기에 구현 
			 */
		}
	}
}
