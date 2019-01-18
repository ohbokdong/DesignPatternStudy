package factory_method.framework;

public abstract class ItemCreator {

	public Item create() { // create()�� template methodó�� ��
		Item item;
		
		requestItemsInfo();
		item = createItem();
		createItemLog();
		
		return item;
	}
	
	// 1. �������� �����ϱ� �� DB���� ������ ������ ��û
	abstract protected void requestItemsInfo();
	
	// 3. �������� ���� �� ������ ���� �� �ҹ� ������ ���� DB�� ������ ���� ������ �����.
	abstract protected void createItemLog();
	
	// 2. �������� �����ϴ� �˰���
	abstract protected Item createItem();
}
