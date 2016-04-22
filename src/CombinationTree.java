import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationTree<T> {
	
	private Node root;
	
	
	public CombinationTree(Node root) {
		this.root = root;
	}
	
	public CombinationTree(char[] array, int depth) {
		root = new Node();
		this.root = populateTree(array,root,depth);
	}

	
	private Node populateTree(char[] array, Node parent, int maxDepth) {
		Arrays.sort(array);
		if (maxDepth == 1) {
			ArrayList<Node> elements = new ArrayList<Node>();
			for(char el : array)
				elements.add(new Node(el,parent,new ArrayList<>()));
			parent.setChildren(elements);
		}
		else {
			
			for(int j = 1;j<array.length;j++) {
				char current = array[j-1];
				Node currentNode = new Node(current,parent);
				if(array.length -j < maxDepth-1 ) {
					break;
				}
						populateTree(Arrays.copyOfRange(array, j, array.length),currentNode,maxDepth-1);
				parent.addChild(currentNode);
			}
		}
		return parent;
	}
	
	
	public String depthFirstTraversal() {
		return depthFirstTraversalFrom(this.root);
	}
	
	private String depthFirstTraversalFrom(Node n) {
		if(n.hasChildren()){
			String result = "";
			for (Node c : n.getChildren()){
				result  = result + depthFirstTraversalFrom(c)+"\n";
			}
			return result;
		}
		else {
			String result=n.getKey()+"";
			Node current= n.getParent();
			while(current.hasParant()) {
				result = current.getKey() + result;
				current = current.getParent();
			}
			return result;
		}
	}
	
}
