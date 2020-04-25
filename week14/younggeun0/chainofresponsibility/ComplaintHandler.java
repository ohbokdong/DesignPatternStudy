package week14.younggeun0.chainofresponsibility;

public class ComplaintHandler extends Handler {
	private String strText;
	public ComplaintHandler(String strText) {
		this.strText = strText;
		this.setSuccessor(new NewLocHandler(strText));
	}
	
	@Override
	public void handleRequest() {
		if (strText.indexOf("ㅅㅂ") != -1 || strText.indexOf("옮기라고") != -1) {
			System.out.println("***************************");
			System.out.println("=>항의 메일로 분류되었습니다.");
			System.out.println("\n");
			/* 
			 * 여기서 법무 담당 부서로 포워딩 처리
			 */
		} else {
			this.getSuccessor().handleRequest();
		}
	}
}
