package week8.younggeun0.templatemethod;

public class Tea {

	void prepareRecipe() {
		boilWater();
		steepTeaBag();
		addLemon();
		pourInCup();
	}
	
	
	public void boilWater() {
		System.out.println("boiling water...");
	}
	
	public void steepTeaBag() {
		System.out.println("steeping tea bag...");
	}
	
	public void pourInCup() {
		System.out.println("pouring in a cup...");
	}
	
	public void addLemon() {
		System.out.println("adding some lemon...");
	}
}
