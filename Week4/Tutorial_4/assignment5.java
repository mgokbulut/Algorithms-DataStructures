package Tutorial_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class assignment5 {
	public static void main(String[] args) {
		Tree tree = new Tree(1, Arrays.asList(
				new Tree(2,
						Arrays.asList(new Tree(5,
								Arrays.asList(new Tree(14, Arrays.asList(new Tree(19))), new Tree(15), new Tree(16),
										new Tree(17))),
								new Tree(6), new Tree(7))),
				new Tree(3, Arrays.asList(new Tree(8), new Tree(9), new Tree(10))),
				new Tree(4, Arrays.asList(new Tree(11), new Tree(12), new Tree(13, Arrays.asList(new Tree(18)))))));
		List<Integer> res = Solution2.bfs(tree);
		System.out.println(19 + " size  : " + res.size());
		Map<Integer, Integer> depthMap = new HashMap<>();
		depthMap.put(1, 0);
		depthMap.put(2, 1);
		depthMap.put(3, 1);
		depthMap.put(4, 1);
		depthMap.put(5, 2);
		depthMap.put(6, 2);
		depthMap.put(7, 2);
		depthMap.put(8, 2);
		depthMap.put(9, 2);
		depthMap.put(10, 2);
		depthMap.put(11, 2);
		depthMap.put(12, 2);
		depthMap.put(13, 2);
		depthMap.put(14, 3);
		depthMap.put(15, 3);
		depthMap.put(16, 3);
		depthMap.put(17, 3);
		depthMap.put(18, 3);
		depthMap.put(19, 4);
		int currentDepth = 0;
		for (int i = 0; i < res.size(); i++) {
			if (currentDepth != depthMap.get(res.get(i))) {
				currentDepth++;
			}
			System.out.println(currentDepth + " " + (int) depthMap.get(res.get(i)));
		}
	}
}

class Solution2 {

	/**
	 * Traverses the tree in a breadth first search order. The result will be a list
	 * containing the key of each node in the correct order.
	 *
	 * @param tree - the tree that will be traversed
	 * @return list containing the keys of each node in the correct order
	 */
	public static List<Integer> bfs(Tree tree) {
		List<Integer> list = new ArrayList<Integer>();
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(tree);
		while (!queue.isEmpty()) {
			Tree current = queue.poll();
			list.add(current.getKey());
			List<Tree> children = current.getChildren();
			for (Tree child : children) {
				queue.add(child);
			}
		}
		return list;
	}
}

class Tree {

	private int key;

	private List<Tree> children;

	/**
	 * Constructor without children
	 * 
	 * @param key - the key of the root
	 */
	public Tree(int key) {
		this.key = key;
		this.children = new ArrayList<>();
	}

	/**
	 * Constructor with children
	 * 
	 * @param key      - the key of the root
	 * @param children - a list of all the children
	 */
	public Tree(int key, List<Tree> children) {
		this.key = key;
		this.children = children;
	}

	/**
	 * @return the key of the root of this tree
	 */
	public int getKey() {
		return this.key;
	}

	/**
	 * @return the children of the root of this tree
	 */
	public List<Tree> getChildren() {
		return this.children;
	}

	/**
	 * Add a children (subtree with one or more nodes) to this tree.
	 * 
	 * @param tree - the tree that needs to be added
	 */
	public void addChildren(Tree tree) {
		this.children.add(tree);
	}
}
