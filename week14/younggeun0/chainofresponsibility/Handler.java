package week14.younggeun0.chainofresponsibility;

public abstract class Handler {
	
	private Handler successor; // 다음 처리할 핸들러를 멤버로 들고 있음

	public abstract void handleRequest();
	
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	public Handler getSuccessor() {
		return successor;
	}
}
