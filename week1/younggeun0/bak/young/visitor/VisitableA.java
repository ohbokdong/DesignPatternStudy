package visitor;

public class VisitableA implements Visitable {

	private int age;
	
	public VisitableA(int age) {
		this.age = age;
	}
	
	@Override
	public void accpet(Visitor visitor) {
		visitor.visit(this);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
