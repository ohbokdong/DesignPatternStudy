package week14.minj0i.prototype;

public class Rectangle extends Shape{
	public Rectangle() {
		this.type = type.Rectangle;
	}

	@Override
	void draw() {
		System.out.println("[Rectangle]입니다.");
	}
}
