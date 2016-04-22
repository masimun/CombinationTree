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

	
	public Node populateTree(char[] array, Node parent, int maxDepth) {
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
				ArrayList<Node> elements = new ArrayList<Node>();
				Node currentNode = new Node(current,root);
				if(array.length -j < maxDepth-1 ) {
					break;
				}
				elements.add(populateTree(Arrays.copyOfRange(array, j, array.length),currentNode,maxDepth-1));
				parent.addChild(currentNode);
			}
		}
		return parent;
	}
	
}
