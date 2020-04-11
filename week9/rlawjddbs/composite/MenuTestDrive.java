package week9.rlawjddbs.composite;

public class MenuTestDrive {

	public static void main(String[] args) {
		MenuComponent pancakeHouseMenu = new Menu("팬케이크 하우스 메뉴", "아침 메뉴");
		MenuComponent dinerMenu = new Menu("객체마을 식당 메뉴", "점심 메뉴");
		MenuComponent cafeMenu = new Menu("카페 메뉴", "저녁 메뉴");
		MenuComponent dessertMenu = new Menu("디저트 메뉴", "디저트를 즐겨 보세요!");
		
		MenuComponent allMenus = new Menu("전체 메뉴", "전체 메뉴");
		
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		
		// 메뉴 항목을 추가하는 부분
		pancakeHouseMenu.add(new MenuItem("K&B 팬케이크 세트", "스크램블드 에그와 토스트가 곁들여진 팬케이크", true, 2.99));
		pancakeHouseMenu.add(new MenuItem("레귤러 팬케이크 세트", "달걀 후라이와 소시지가 곁들여진 팬케이크", false, 2.99));
		pancakeHouseMenu.add(new MenuItem("블루베리 팬케이크", "신선한 블루베리와 블루베리 시럽으로 만든 팬케이크", true, 3.49));
		dinerMenu.add(new MenuItem("채식주의자용 BLT", "통밀 위에 (식물성)베이컨, 상추, 토마토를 얹은 메뉴", true, 2.99));
		dinerMenu.add(new MenuItem("BLT", "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴", false, 2.99));
		dinerMenu.add(new MenuItem("오늘의 스프", "감자 샐러드를 곁들인 오늘의 스프", false, 3.29));
		dinerMenu.add(new MenuItem("핫도그", "사워크라우트, 갖은 양념, 양파, 치즈가 곁들여진 핫도그", false, 3.05));
		cafeMenu.add(new MenuItem("베지 버거와 에어 프라이", "통밀빵, 상추, 토마토, 감자튀김이 첨가된 베지 버거", true, 3.99));
		cafeMenu.add(new MenuItem("오늘의 스프", "샐러드가 곁들여진 오늘의 스프", true, 3.99));
		cafeMenu.add(new MenuItem("베리또", "통 핀토콩과 살사, 구아카몰이 곁들여진 푸짐한 베리또", true, 3.99));
		
		// 메뉴에 메뉴를 추가하는 부분
		dinerMenu.add(dessertMenu);
		
		dessertMenu.add(new MenuItem(
				"애플 파이", 
				"바삭바삭한 크러스트에 바닐라 아이스크림이 얹혀 있는 애플파이", 
				true, 
				1.59));
		dessertMenu.add(new MenuItem(
				"치즈케이크", 
				"초콜릿 그레이엄 크러스트 위에 부드러운 뉴욕 치즈케이크", 
				true, 
				1.99));
		dessertMenu.add(new MenuItem(
				"소르베", 
				"라스베리와 라임의 절묘한 조화", 
				true, 
				1.89));
		
		// 메뉴 항목을 추가하는 부분
		Waitress waitress = new Waitress(allMenus);
		
		waitress.printMenu();
		waitress.printVegetarianMenu();
	} // main

} // class
