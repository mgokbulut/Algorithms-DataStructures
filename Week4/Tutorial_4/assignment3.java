package Tutorial_4;

import java.util.LinkedList;
import java.util.List;

public class assignment3 {
	public static void main(String[] args) {
		BinaryTree threeLevelTree = new BinaryTree(1, new BinaryTree(2, new BinaryTree(4), new BinaryTree(5)),
				new BinaryTree(3, new BinaryTree(6), new BinaryTree(7)));

		BinaryTree skewTree1 = new BinaryTree(42, new BinaryTree(36, new BinaryTree(21), new BinaryTree(24)),
				new BinaryTree(47));

		BinaryTree skewTree2 = new BinaryTree(42, new BinaryTree(36, new BinaryTree(21), new BinaryTree(24)), null);

		BinaryTree skewTree3 = new BinaryTree(42,
				new BinaryTree(21, new BinaryTree(10, new BinaryTree(5), null), new BinaryTree(31)),
				new BinaryTree(63, new BinaryTree(52, new BinaryTree(47), null), new BinaryTree(84)));

		List<Integer> l = Solution0.postOrder(threeLevelTree);
		for (Integer integer : l) {
			System.out.println(integer);
		}
		System.out.println("-----------");

		l = Solution0.postOrder(skewTree1);
		for (Integer integer : l) {
			System.out.println(integer);
		}
		System.out.println("-----------");

		l = Solution0.postOrder(skewTree2);
		for (Integer integer : l) {
			System.out.println(integer);
		}
		System.out.println("-----------");

		l = Solution0.postOrder(skewTree3);
		for (Integer integer : l) {
			System.out.println(integer);
		}
	}
}

class Solution0 {

	/**
	 * @param tree The input BinaryTree.
	 * @return A list of all keys in the tree, in post-order.
	 */
	public static List<Integer> postOrder(BinaryTree tree) {
		if (tree == null) {
			return new LinkedList<Integer>();
		}
		List<Integer> left = new LinkedList<Integer>();
		List<Integer> right = new LinkedList<Integer>();
		if (tree.hasLeft()) {
			if (tree.getLeft() != null) {
				left = postOrder(tree.getLeft());
			}
		}
		if (tree.hasRight()) {
			if (tree.getRight() != null) {
				right = postOrder(tree.getRight());
			}
		}
		if (!tree.hasLeft() && !tree.hasRight()) {
			List<Integer> l = new LinkedList<Integer>();
			l.add(tree.getKey());
			return l;
		} else {
			left.addAll(right);
			left.add(tree.getKey());
			return left;
		}
	}
}

class BinaryTree {

	int key;

	BinaryTree left, right;

	/**
	 * Simple constructor.
	 *
	 * @param key to set as key.
	 */
	public BinaryTree(int key) {
		this.key = key;
	}

	/**
	 * Extended constructor.
	 *
	 * @param key   to set as key.
	 * @param left  to set as left child.
	 * @param right to set as right child.
	 */
	public BinaryTree(int key, BinaryTree left, BinaryTree right) {
		this(key);
		setLeft(left);
		setRight(right);
	}

	/**
	 * @return The key of this BinaryTree node.
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @return the left child.
	 */
	public BinaryTree getLeft() {
		return left;
	}

	/**
	 * @return the right child.
	 */
	public BinaryTree getRight() {
		return right;
	}

	/**
	 * @return true iff this BinaryTree node has a left child, false otherwise.
	 */
	public boolean hasLeft() {
		return left != null;
	}

	/**
	 * @return true iff this BinaryTree node has a right child, false otherwise.
	 */
	public boolean hasRight() {
		return right != null;
	}

	/**
	 * @param left The BinaryTree node to set as left child.
	 */
	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	/**
	 * @param right The BinaryTree node to set as right child.
	 */
	public void setRight(BinaryTree right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "BinaryTree{" + key + '}';
	}
}
