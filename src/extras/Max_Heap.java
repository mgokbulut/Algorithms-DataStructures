package extras;

import java.util.ArrayList;
import java.util.List;

public class Max_Heap {

	private List<Integer> heap;

	public Max_Heap() {
		heap = new ArrayList<>();
	}

	/**
	 * Swaps two elements in the list.
	 *
	 * @param i Position of element to swap in a.
	 * @param j Position of element to swap in a.
	 */
	private void swap(int i, int j) {
		int t = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, t);
	}

	/**
	 * Restores the heap property in a heap represented as an arraylist. When the
	 * heap property is invalid at root, the method fixes the heap first locally
	 * before fixing the affected subtree.
	 *
	 * @param root  Index of the root of the heap, which might be a subtree of the
	 *              overall heap.
	 * @param range Index of the last element in the heap, array elements with an
	 *              index > range are not part of the heap.
	 */
	public void downHeap(int root, int range) {

		// index of left and right children
		int left = 2 * root + 1;
		int right = 2 * root + 2;

		int biggest;

		if (left <= range && heap.get(left) > heap.get(root))
			biggest = left;
		else
			biggest = root;

		if (right <= range && heap.get(right) > heap.get(biggest))
			biggest = right;

		// heap property invalid at root
		if (biggest != root) {
			swap(root, biggest);
			downHeap(biggest, range);
		}
	}

	/**
	 * Restores the heap property in a heap represented as an arraylist. The method
	 * compares the node to its parent and swaps if necessary.
	 *
	 * @param i index of the node
	 */
	public void upHeap(int i) {
		while (i >= 1) {
			int j = (i - 1) / 2;
			if (heap.get(j) >= heap.get(i))
				break;
			swap(j, i);
			i = j;
		}
	}

	/**
	 * Inserts the specified element into this priority queue.
	 *
	 * @param i element to add
	 */
	public void add(int i) {
		heap.add(i);
		upHeap(heap.size() - 1);
	}

	/**
	 * Retrieves and removes the first element of this priority queue.
	 *
	 * @return the first element of the queue
	 */
	public int poll() {
		int i = heap.get(0);
		swap(0, heap.size() - 1);
		heap.remove(heap.size() - 1);
		downHeap(0, heap.size() - 1);
		return i;
	}

	/**
	 * @return the current number of elements in the heap
	 */
	public int size() {
		return this.heap.size();
	}
}
