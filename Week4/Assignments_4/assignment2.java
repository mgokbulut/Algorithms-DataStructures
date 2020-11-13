package Assignments_4;

public class assignment2 {

}

//class Solution {
//	/**
//	 * Computes whether the BinaryTree is complete.
//	 *
//	 * @param tree the BinaryTree to check.
//	 * @return true iff the BinaryTree is complete, else false.
//	 */
//	public static boolean isTreeComplete(BinaryTree tree) {
//		if (tree == null) {
//			return true;
//		}
//		Queue<BinaryTree> nodes = new ArrayDeque<BinaryTree>();
//		nodes.add(tree);
//		boolean hit = false;
//		while (!nodes.isEmpty()) {
//
//			BinaryTree current = nodes.poll();
//			System.out.println(current.getKey());
//
//			if (current.hasLeft() && current.hasRight()) {
//				if (hit)
//					return false;
//				nodes.add(current.getLeft());
//				nodes.add(current.getRight());
//			} else if (current.hasLeft()) {
//				if (hit)
//					return false;
//				nodes.add(current.getLeft());
//				hit = true;
//			} else if (current.hasRight()) {
//				return false;
//			} else {
//				hit = true;
//			}
//
//		}
//		return true;
//		// if(tree.hasLeft() && tree.hasRight()){
//		// nodes.add(tree.getLeft());
//		// nodes.add(tree.getRight());
//		// } else if(tree.hasLeft()) {
//		// nodes.add(tree.getLeft());
//		// } else if(tree.hasRight()) {
//		// return false;
//		// } else {
//		// return true;
//		// }
//
//	}
//}
