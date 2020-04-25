package week14.younggeun0.chainofresponsibility;

public class SpamHandler extends Handler {
	private String strText;
	public SpamHandler(String strText) {
		this.strText = strText;
		this.setSuccessor(new FanHandler(strText));
	}
	
	@Override
	public void handleRequest() {
		if (strText.indexOf("광고") != -1) {
			System.out.println("***************************");
			System.out.println("=>광고 메일로 분류되었습니다.");
			System.out.println("\n");
			/* 
			 * 메일을 삭제하는 처리
			 */
		} else {
			this.getSuccessor().handleRequest();
		}
	}
}
