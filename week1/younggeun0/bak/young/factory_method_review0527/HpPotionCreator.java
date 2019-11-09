package factory_method_review0527;

import java.util.Date;

public class HpPotionCreator extends ItemCreator {

	@Override
	protected void requestItemsInfo() {
		System.out.println("�����ͺ��̽����� �ַ� ȸ�� ������ ������ �����ɴϴ�.");
	}

	@Override
	protected Item createItem() {
		return new HpPotion();
	}

	@Override
	protected void createItemLog() {
		System.out.println("ü�� ȸ�� ������ ���� �����߽��ϴ�."+new Date());
	}
}
