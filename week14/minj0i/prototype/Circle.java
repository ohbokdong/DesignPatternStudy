package week14.minj0i.prototype;

public class Circle extends Shape{
	public Circle() {
		this.type = type.CIRCLE;
	}

	@Override
	void draw() {
		System.out.println("[circle]입니다.");
	}
}
