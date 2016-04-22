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
		
		for(int j = 0;j<array.length-1;j++) {
			char current = array[j];
			
			ArrayList<Node> elements = new ArrayList<Node>();
			Node currentNode = new Node(current,root);
			for(int i=j+1;i<array.length-1;i+=(maxDepth-1)) {
				elements.add(populateTree(Arrays.copyOfRange(array, i, array.length),currentNode,maxDepth-1));
				//elements.add(new Node(array[i],parent));
			}
			currentNode.setChildren(elements);
			parent.addChild(currentNode);
		}
		return parent;
	}
	
}
