package week1.sgmsgood.example;

public class Simulator {

	public static void main(String[] args) {
		Roboto roboto = new FriendRoboto();
		
	    roboto.charge();
	    roboto.performCook();
	    roboto.performTalk();
	    
	    System.out.println("");
	    
	    Roboto healtyCookingRoboto = new CookingRoboto();
	    healtyCookingRoboto.charge();
	    healtyCookingRoboto.performCook();
	    healtyCookingRoboto.performTalk();
	    
	}

}
