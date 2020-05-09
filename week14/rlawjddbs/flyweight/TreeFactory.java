package week14.flyweight;

public class TreeFactory {
	Tree p, b = null;
	public TreeFactory() {
		this.p = new PineTree();
		this.b = new BaobabTree();
	}
	public Tree getTree(String type) throws Exception {
		if (type.equals("pine")) {
			return this.p;
		} else if (type.equals("baobab")) {
			return this.b;
		} else {
			throw new Exception("구할 수 없는 나무 종류 : " + type);
		}
	}
}