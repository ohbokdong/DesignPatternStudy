package factory_method_review0527;

import java.util.Date;

public class MpPotionCreator extends ItemCreator {

	@Override
	protected void requestItemsInfo() {
		System.out.println("DB에서 마력 회복 물약의 정보를 가져옵니다");
	}
	
	@Override
	protected void createItemLog() {
		System.out.println("마력 회복 물약을 새로 생성했습니다 "+new Date());
	}

	@Override
	protected Item createItem() {
		// 작업
		return new MpPotion();
	}
}
