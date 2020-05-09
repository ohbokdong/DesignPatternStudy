package week14.nonflyweight;

public class Client {
	public static void main(String[] args) {
		Tree pineTree1 = new Tree("소나무", 5, 2, 2);
		Tree pineTree2 = new Tree("소나무", 12, 6, 3);
		Tree pineTree3 = new Tree("소나무", 7, 8, 6);
		Tree pineTree4 = new Tree("소나무", 5, 2, 8);
		Tree baobabTree1 = new Tree("바오밥나무", 30, 7, 5);
		Tree baobabTree2 = new Tree("바오밥나무", 15, 1, 6);
		Tree baobabTree3 = new Tree("바오밥나무", 8, 9, 8);
		
		pineTree1.display();
		pineTree2.display();
		pineTree3.display();
		pineTree4.display();
		baobabTree1.display();
		baobabTree2.display();
		baobabTree3.display();
	}
}
