package Tutorial_4;

import java.util.Arrays;

public class assignment6 {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 8, 4, 7, 11, 7, 3, 82, 22 };
		int[] arr1 = { 2, 5, 7, 8 };
		int[] arr2 = { 1, 4, 6, 7, 9 };
		int[] res = sort2arrays(arr1, arr2);
		for (int i : res) {
			System.out.print(i + " ");
		}
		int[] res2 = mergeSort(arr);

		System.out.println();
		for (int i : res2) {
			System.out.print(i + " ");
		}
//		int[] debug1 = { 3 };
//		int[] debug2 = { 22, 82 };
//		int[] resdebug = sort2arrays(debug1, debug2);
//		for (int i : resdebug) {
//			System.out.print(i + " ");
//		}
	}

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
