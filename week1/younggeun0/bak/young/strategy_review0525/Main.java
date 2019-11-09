package strategy_review0525;

public class Main {
	
	public static void main(String[] args) {
		
		Character c = new Character();
		
		c.attack(); // ¸Ç¼Õ
		
		c.setWeapon(new Knife());
		c.attack();
		
		c.setWeapon(new Sword());
		c.attack();
		
		c.setWeapon(new Axe());
		c.attack();
		
	}
}
