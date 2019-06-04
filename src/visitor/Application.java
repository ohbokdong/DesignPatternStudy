package visitor;

import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		
		ArrayList<Visitable> visitables = new ArrayList<Visitable>();
		visitables.add(new VisitableA(1));
		visitables.add(new VisitableA(2));
		visitables.add(new VisitableA(3));
		visitables.add(new VisitableA(4));
		visitables.add(new VisitableA(5));
		
		Visitor visitor = new VisitorA(); // Visitor가
		
		// Visitable을 방문해서 어떤 일을 수행
		for(Visitable visitable : visitables) { 
			visitable.accpet(visitor);
		}
		
		System.out.println(((VisitorA)visitor).getAgeSum());
	}
}
