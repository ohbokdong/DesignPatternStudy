package factory_method_review0527;

public abstract class ItemCreator {
	public Item create() { // create()는 template method처럼 사용
		Item item;
		
		requestItemsInfo();
		item = createItem();
		createItemLog();
		
		return item;
	}
	
	// 1. 아이템을 생성하기 전 DB에 아이템 정보를 요청
	protected abstract void requestItemsInfo();
	
	// 2. 아이템을 생성하는 알고리즘
	protected abstract Item createItem();
	
	// 3. 아이템을 생성 후 아이템 복제 등 불법 방지를 위해 DB에 아이템 생성 정보를 남김
	protected abstract void createItemLog();
}
