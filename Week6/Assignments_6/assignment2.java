package Assignments_6;

import java.util.LinkedList;
import java.util.Queue;

public class assignment2 {
	public static Queue<Integer>[] fillBuckets(int[] array) {
		if (array == null || array.length == 0) {
			return new Queue[0];
		}
		int vmin = array[0];
		int vmax = array[0];

		for (int i : array) {
			if (i < vmin) {
				vmin = i;
			} else if (i > vmax) {
				vmax = i;
			}
		}

		Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];

		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}

		for (int val : array) {
			buckets[val - vmin].add(val);
		}

		return buckets;
	}

	public static int[] readBuckets(Queue<Integer>[] buckets) {
		int size = 0;
		for (Queue<Integer> queue : buckets) {
			size += queue.size();
		}

		int[] arr = new int[size];
		int i = 0;

		for (Queue<Integer> queue : buckets) {
			while (!queue.isEmpty()) {
				arr[i] = queue.poll();
				i++;
			}
		}
		return arr;
	}
}
