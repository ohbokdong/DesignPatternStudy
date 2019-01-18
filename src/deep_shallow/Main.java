package deep_shallow;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Cat navi = new Cat();
		navi.setName("navi");
		navi.setAge(new Age(2015, 3));
		
		Cat yo = navi.copy();
		yo.setName("yo");
		yo.getAge().setYear(2018);
		yo.getAge().setValue(2);
		
		System.out.println(navi.getName());
		System.out.println(yo.getName());
		
		System.out.println(navi.getAge().getYear());
		System.out.println(yo.getAge().getYear());
		
		System.out.println(navi.getAge().getValue());
		System.out.println(yo.getAge().getValue());
	}
}
