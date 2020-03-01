package week9.younggeun0.iterator;

public class DinnerMenu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems; // 저녁메뉴는 배열을 이용하여 만듦
	
	public DinnerMenu() {
		menuItems = new MenuItem[MAX_ITEMS]; // 메뉴의 크기가 정해져 있음
		
		addItem("채식 주의자용 BLT", "통밀 위에 식물성 베이컨, 상추, 토마토를 얹은 메뉴", true, 2.99);
		addItem("BLT", "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴", false, 2.99);
		addItem("오늘의 스프", "감자 샐러드를 곁들인 오늘의 스프", false, 3.29);
		addItem("핫도그", "사워크라우트, 갖은 양념, 양파, 치즈가 곁들여진 핫도그", false, 3.05);
		// 기타 메뉴 항목이 추가되는 부분
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		
		if (numberOfItems >= MAX_ITEMS) {
			System.out.println("죄송합니다. 메뉴가 꽉 찼습니다. 더 이상 추가할 수 없어요.");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems++;
		}
	}

	public MenuItem[] getMenuItems() {
		return menuItems;
	}
	// 기타 메뉴 관련 메소드(배열 형태로 구현해 놓은 메뉴에 의존하는 메소드를 만들어 놓음)
}
