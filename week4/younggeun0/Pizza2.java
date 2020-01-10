package week4.younggeun0;

public abstract class Pizza2 {
	String name;
	Dough dough;
	Sauce sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;
	
	// prepare메소드를 추상 메소드로 변경, 피자를 만드는 데 필요한 재료들을 정돈
	abstract void prepare();
	
	// prepare를 제외한 메소드들은 바뀌지 않음
	
	void bake() {
		System.out.println("25분동안 350도에서 굽자...");
	}
	
	void cut() {
		System.out.println("피자를 조각조각 자르자...");
	}
	
	void box() {
		System.out.println("포장포장...");
	}
	
	public String getName() {
		return name;
	}

	public Dough getDough() {
		return dough;
	}

	public void setDough(Dough dough) {
		this.dough = dough;
	}

	public Sauce getSauce() {
		return sauce;
	}

	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	public Veggies[] getVeggies() {
		return veggies;
	}

	public void setVeggies(Veggies[] veggies) {
		this.veggies = veggies;
	}

	public Cheese getCheese() {
		return cheese;
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	public Pepperoni getPepperoni() {
		return pepperoni;
	}

	public void setPepperoni(Pepperoni pepperoni) {
		this.pepperoni = pepperoni;
	}

	public Clams getClam() {
		return clam;
	}

	public void setClam(Clams clam) {
		this.clam = clam;
	}

	public void setName(String name) {
		this.name = name;
	}
}
