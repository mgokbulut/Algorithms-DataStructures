package extras;

import java.util.Arrays;

public class Merge_Sort {

	/**
	 * Sorts an array of integers in ascending order. This operation is
	 * not-in-place.
	 *
	 * @param arr the array of integers that needs to be sorted in ascending order.
	 */
	public static int[] mergeSort(int[] arr) {
		if (arr.length > 1) {
			int[] left = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
			int[] right = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
			return sort2arrays(left, right);

		} else {
			System.out.println(arr[0]);
			return arr;
		}

	}

	public static int[] sort2arrays(int[] arr1, int[] arr2) {
		int[] res = new int[arr1.length + arr2.length];
		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i < res.length; i++) {
			if (p1 == -1) {
				res[i] = arr2[p2];
				p2++;
			} else if (p2 == -1) {
				res[i] = arr1[p1];
				p1++;
			} else if (arr1[p1] < arr2[p2]) {
				res[i] = arr1[p1];
				p1++;
				if (p1 == arr1.length) {
					p1 = -1;
				}
			} else {
				res[i] = arr2[p2];
				p2++;
				if (p2 == arr2.length) {
					p2 = -1;
				}
			}
		}
		return res;
	}
}
