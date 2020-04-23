package week14.younggeun0.chainofresponsibility;

public class FanHandler extends Handler {
	private String strText;
	public FanHandler(String strText) {
		this.strText = strText;
		this.setSuccessor(new ComplaintHandler(strText));
	}
	
	@Override
	public void handleRequest() {
		if (strText.indexOf("팬") != -1 || strText.indexOf("사장") != -1) {
			System.out.println("***************************");
			System.out.println("=>팬 메일로 분류되었습니다.");
			System.out.println("\n");
			/* 
			 * 여기서 CEO에게 포워딩 처리
			 */
		} else {
			this.getSuccessor().handleRequest();
		}
	}
}
