package factory_method.concrete;

import factory_method.framework.Item;
import factory_method.framework.ItemCreator;

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
