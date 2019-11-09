package factory_method.concrete;

import java.util.Date;

import factory_method.framework.Item;
import factory_method.framework.ItemCreator;

public class MpPotionCreator extends ItemCreator {

	@Override
	protected void requestItemsInfo() {
		System.out.println("�����ͺ��̽����� ���� ȸ�� ������ ������ �����ɴϴ�.");
	}

	@Override
	protected void createItemLog() {
		System.out.println("���� ȸ�� ������ ���� �����߽��ϴ�."+new Date());
	}

	@Override
	protected Item createItem() {
		// �۾�..
		return new MpPotion();
	}
}
