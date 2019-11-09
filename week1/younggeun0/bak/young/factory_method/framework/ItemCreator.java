package factory_method.framework;

public abstract class ItemCreator {

	public Item create() { // create()는 template method처럼 됨
		Item item;
		
		requestItemsInfo();
		item = createItem();
		createItemLog();
		
		return item;
	}
	
	// 1. 아이템을 생성하기 전 DB에서 아이템 정보를 요청
	abstract protected void requestItemsInfo();
	
	// 3. 아이템을 생성 후 아이템 복제 등 불법 방지를 위해 DB에 아이템 생성 정보를 남긴다.
	abstract protected void createItemLog();
	
	// 2. 아이템을 생성하는 알고리즘
	abstract protected Item createItem();
}
