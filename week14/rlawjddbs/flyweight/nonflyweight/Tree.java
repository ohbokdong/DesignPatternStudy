package week14.nonflyweight;

public class Tree {
	private String treeName;
	private int age;
	private int xCoord;
	private int yCoord;
	
	private Tree() {
	}
	
	public Tree(String treeName, int age, int xCoord, int yCoord) {
		this.treeName = treeName;
		this.age = age;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public void display() {
		System.out.println("[" + treeName + " - 수령:" + age + "년 / x:" + xCoord + " / y:" + yCoord + "]");
	}
}
