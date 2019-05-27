package factory_method_review0527;

import java.util.Date;

public class MpPotionCreator extends ItemCreator {

	@Override
	protected void requestItemsInfo() {
		System.out.println("DB���� ���� ȸ�� ������ ������ �����ɴϴ�");
	}
	
	@Override
	protected void createItemLog() {
		System.out.println("���� ȸ�� ������ ���� �����߽��ϴ� "+new Date());
	}

	@Override
	protected Item createItem() {
		// �۾�
		return new MpPotion();
	}
}
