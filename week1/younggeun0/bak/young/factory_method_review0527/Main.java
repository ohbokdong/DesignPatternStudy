package factory_method_review0527;

public class Main {

	public static void main(String[] args) {
		ItemCreator creator;
		Item item;
		
		creator = new HpPotionCreator();
		item = creator.create();
		item.use();
		
		creator = new MpPotionCreator();
		item = creator.create();
		item.use();
	}
}
