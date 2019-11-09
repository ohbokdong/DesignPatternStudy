package facade;

class HelpSystem3 { // default, package내에서만 접근 가능
	
	public HelpSystem3() {
		System.out.println("Call Constructor : " + getClass().getSimpleName());
	}
	
	public void process() {
		System.out.println("Call Process" + getClass().getSimpleName());
	}

	
}
