package Tutorial_4;

public class assignment4 {
	public static void main(String[] args) {
		Node tree = new InternalNode("-", new LeafNode(12),
				new InternalNode("+", new InternalNode("*", new LeafNode(3), new LeafNode(13)),
						new InternalNode("*", new LeafNode(39), new InternalNode("+", new LeafNode(6),
								new InternalNode("-", new LeafNode(14), new LeafNode(2))))));
		System.out.println(-729 + " " + Solution1.eval(tree));
	}
}

class Solution1 {
	/**
	 * Evaluates the arithmetic expression stored in this binary tree.
	 *
	 * @param node
	 * @return
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("rawtypes")
	public static int eval(Node node) throws IllegalArgumentException {
		if (node instanceof LeafNode) {
			return (int) node.val;
		} else {
			InternalNode internalNode = (InternalNode) node;
			switch (internalNode.val) {
			case "+":
				return eval(internalNode.left) + eval(internalNode.right);
			case "-":
				return eval(internalNode.left) - eval(internalNode.right);
			case "*":
				return eval(internalNode.left) * eval(internalNode.right);
			default:
				throw new IllegalArgumentException();
			}
		}
	}
}

abstract class Node<T> {
	public T val;
}

/**
 * Internal Node that stores an operator represented as a string
 */
@SuppressWarnings("rawtypes")
class InternalNode extends Node<String> {
	public Node left;
	public Node right;

	public InternalNode(String operator, Node left, Node right) {
		this.val = operator;
		this.left = left;
		this.right = right;
	}
}

/**
 * Leaf Node that stores an operand represented as an integer
 */
class LeafNode extends Node<Integer> {
	public LeafNode(int constant) {
		this.val = constant;
	}
}
