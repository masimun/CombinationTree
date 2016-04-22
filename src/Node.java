import java.util.ArrayList;
import java.util.List;

public class Node {

	private char key;
	
	private Node parent;
	
	private List<Node> children;
	
	
	public Node(char key, Node parent, List<Node> children) {
		this.key = key;
		this.parent = parent;
		this.children = children;
	}
	
	public Node(char key, Node parent) {
		this.key = key;
		this.parent = parent;
		this.children =  new ArrayList<Node>();
	}
	
	public Node() {
		this.key = ' ';
		this.parent = null;
		this.children = new ArrayList<Node>();
	}
	
	public boolean isRoot() {
		if (parent == null) {
			return true;
		}
		return false;
	}
	
	public char getKey() {
		return this.key;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	public void addChild(Node e) {
		this.children.add(e);
	}
	
	@Override
	public String toString() {
		return "Node: " + key;
		
	}

	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean hasParant() {
		return parent != null;
	}
	
	
}
