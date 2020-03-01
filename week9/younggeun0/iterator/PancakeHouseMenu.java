package week9.younggeun0.iterator;

import java.util.ArrayList;

public class PancakeHouseMenu {
	ArrayList<MenuItem> menuItems; // 팬케이크하우스는 ArrayList로 메뉴를 관리
	
	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
		
		addItem("K&B 팬케이크 세트", "스크램블드 에그, 토스트가 곁들여진 팬케이크", true, 2.99);
		addItem("레큘러 팬케이크 세트", "달걀후라이, 소시지가 곁들여진 팬케이크", false, 2.99);
		addItem("블루베리 팬케이크", "신선한 블루베리와 시럽으로 만든 팬케이크", true, 3.49);
		addItem("와플", "와플, 취향에 따라 블루베리나 딸기를 얹을 수 있음", true, 3.59);
		
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		menuItems.add(new MenuItem(name, description, vegetarian, price));
	}
	
	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}
	
	// 기타 메뉴 관련 메소드(ArrayList를 이용해서 구현한 코드에 의존하는 다른 코드들이 있다 가정)
}
