package week14.flyweight;

public class Client {
	public static void main(String[] args) {
		int[][] pineTrees = {{5, 2, 2}, {12, 6, 3}, {7, 8, 6}, {5, 2, 8}};
		int[][] baobabTrees = {{30, 7, 5}, {15, 1, 6}, {8, 9, 8}};
		TreeFactory treeFactory = new TreeFactory(); // creates the two flyweights
		Tree d, c;
		try {
			d = treeFactory.getTree("pine");
			c = treeFactory.getTree("baobab");
			for (int[] pineTree : pineTrees) {
				d.display(pineTree[0], pineTree[1], pineTree[2]);
			}
			for (int[] baobabTree : baobabTrees) {
				c.display(baobabTree[0], baobabTree[1], baobabTree[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}