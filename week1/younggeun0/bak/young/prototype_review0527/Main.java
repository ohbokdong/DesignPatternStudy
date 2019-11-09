package prototype_review0527;

public class Main {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Circle c1 = new Circle(1,1,3);
		Circle c2 = c1.copy();
		
		System.out.println(c1.getX()+", "+c1.getY()+", "+c1.getR());
		System.out.println(c2.getX()+", "+c2.getY()+", "+c2.getR());
		
		
	}

}
