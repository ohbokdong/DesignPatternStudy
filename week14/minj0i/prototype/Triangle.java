package week14.minj0i.prototype;

public class Triangle extends Shape{
	public Triangle() {
		this.type = type.Triangle;
	}

	@Override
	void draw() {
		System.out.println("[Triangle]입니다.");
	}
}
