package factory_method_review0527;

public abstract class ItemCreator {
	public Item create() { // create()�� template methodó�� ���
		Item item;
		
		requestItemsInfo();
		item = createItem();
		createItemLog();
		
		return item;
	}
	
	// 1. �������� �����ϱ� �� DB�� ������ ������ ��û
	protected abstract void requestItemsInfo();
	
	// 2. �������� �����ϴ� �˰���
	protected abstract Item createItem();
	
	// 3. �������� ���� �� ������ ���� �� �ҹ� ������ ���� DB�� ������ ���� ������ ����
	protected abstract void createItemLog();
}
