package factory_method.concrete;

import factory_method.framework.Item;

public class HpPotion implements Item {

	@Override
	public void use() {
		System.out.println("ü�� ȸ��!");
	}
}
