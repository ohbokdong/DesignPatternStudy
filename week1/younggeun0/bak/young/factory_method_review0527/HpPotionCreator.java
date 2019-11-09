package factory_method_review0527;

import java.util.Date;

public class HpPotionCreator extends ItemCreator {

	@Override
	protected void requestItemsInfo() {
		System.out.println("데이터베이스에서 최력 회복 물약의 정보를 가져옵니다.");
	}

	@Override
	protected Item createItem() {
		return new HpPotion();
	}

	@Override
	protected void createItemLog() {
		System.out.println("체력 회복 물약을 새로 생성했습니다."+new Date());
	}
}
