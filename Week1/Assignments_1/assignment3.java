package Assignments_1;

import java.util.Arrays;

public class assignment3 {

	/**
	 * Implement a method merge that, given two arrays of sorted integer elements,
	 * returns a new sorted array with all the elements of the two input arrays.
	 * 
	 * Assume that the elements in both input arrays are sorted in non-decreasing
	 * order (e.g. [0, 1, 2, 2] and [1, 2, 3, 3, 4, 5]). The returned “merged” array
	 * must keep this property (e.g. [0, 1, 1, 2, 2, 2, 3, 3, 4, 5]).
	 * 
	 * Duplicates are allowed in both the input and the output.
	 * 
	 * If either one of the arrays are null, return the non-null array as a copy, if
	 * both arrays are null, the result should be null as well.
	 * 
	 * Efficiency requirement: the arrays should be merged in a single pass over the
	 * arrays.
	 */
	public static void main(String[] args) {

		test4();

	}

	/**
	 * This is valid even for unsorted lists but the specification assumes the
	 * parametarized arrays are sorted
	 */
	public static int[] merge_v1(int[] arr1, int[] arr2) {

		// checking if the arrays are null
		if ((arr1 == null || arr1.length == 0) && (arr2 == null || arr2.length == 0)) {
			return null;
		} else if (arr1 == null || arr1.length == 0) {
			return arr2;
		} else if (arr2 == null || arr2.length == 0) {
			return arr1;
		}

		int[] result = new int[arr1.length + arr2.length];
		boolean[] isUsed = new boolean[arr1.length + arr2.length];
		Arrays.fill(isUsed, false);

		int index = -1;
		boolean check;
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.MIN_VALUE;
			check = false;

			for (int j = 0; j < arr1.length; j++) {
				// if the current int is greater than lowest and is not used
				if ((check == false && isUsed[j] == false) || (result[i] > arr1[j] && isUsed[j] == false)) {
					result[i] = arr1[j];
					index = j;
					check = true;
					// isUsed[j] = true;
				}
			}
			for (int j = 0; j < arr2.length; j++) {
				// if the current int is greater than lowest and is not used
				if ((check == false && isUsed[j + arr1.length] == false)
						|| (result[i] > arr2[j] && isUsed[j + arr1.length] == false)) {
					result[i] = arr2[j];
					index = j + arr1.length;
					check = true;
					// isUsed[j + + arr1.length] = true;
				}
			}

			isUsed[index] = true;
		}

		return result;
	}

	public static int[] merge_v2(int[] arr1, int[] arr2) {

		// checking if the arrays are null
		if ((arr1 == null || arr1.length == 0) && (arr2 == null || arr2.length == 0)) {
			return null;
		} else if (arr1 == null || arr1.length == 0) {
			return Arrays.copyOf(arr2, arr2.length);
		} else if (arr2 == null || arr2.length == 0) {
			return Arrays.copyOf(arr1, arr1.length);
		}

		// assuming arr1 and arr2 are null
		int pointer1 = 0;
		int pointer2 = 0;
		int[] result = new int[arr1.length + arr2.length];

		for (int i = 0; i < result.length; i++) {

			if (pointer2 > arr2.length - 1) {
				result[i] = arr1[pointer1];
				pointer1++;
			} else if ((pointer1 > arr1.length - 1) || (arr1[pointer1] > arr2[pointer2])) {
				result[i] = arr2[pointer2];
				pointer2++;
			} else {
				result[i] = arr1[pointer1];
				pointer1++;
			}
		}

		return result;
	}

	// -------------Tests-------------//
	public static void test1() {
		int[] arr1 = { 0, 1, 7, 44, 5 };
		int[] arr2 = { 0, 5, 6, 666, 1, 2, 8, 4, 5, 6 };

		int[] arr3 = merge_v1(arr1, arr2);
		for (int i : arr3) {
			System.out.print(i + " ");
		}

	}

	public static void test2() {
		int[] arr1 = { 0, 1, 7, 4, 11, 2, 3, 4, 5 };
		int[] arr2 = { 0, 1, 2, 8, 4, 5, 6 };

		int[] arr3 = merge_v1(arr1, arr2);
		for (int i : arr3) {
			System.out.print(i + " ");
		}

	}

	public static void test3() {
		int[] arr1 = { 0, 1, 2, 3, 6 };
		int[] arr2 = { 0, 1, 2, 4, 6, 7, 8 };

		int[] arr3 = merge_v2(arr1, arr2);
		for (int i : arr3) {
			System.out.print(i + " ");
		}

	}

	public static void test4() {
		int[] arr1 = { 0, 1, 2, 3, 5, 6 };
		int[] arr2 = { 3, 3, 2, 4, 6, 7, 8 };

		int[] arr3 = merge_v2(arr1, arr2);
		for (int i : arr3) {
			System.out.print(i + " ");
		}

	}
}
