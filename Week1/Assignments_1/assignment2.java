package Assignments_1;

public class assignment2 {
	/**
	 * Implement a method named reverse that, given an array of integer elements,
	 * reverses the order of its elements in-place.
	 * 
	 * In-place means that you reverse the order of the elements in the array
	 * itself, without using an auxiliary array or any other additional data
	 * structures.
	 * 
	 * When the array is null nothing should happen and the algorithm should
	 * terminate.
	 * 
	 * For example: given the array [1, 2, 3, 4, 5], the expected result would be
	 * [5, 4, 3, 2, 1].
	 * 
	 * IMPORTANT: In an exam setting, your grade for this exercise would be
	 * overridden to 1, if your algorithm isn’t in-place.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		test1();
		test2();
		test3();
		test4();

	}

	/**
	 * reverses th elements of the array
	 * 
	 * @param arr
	 */
	public static void reverse(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}

		int temp;
		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = arr[i];
			arr[i] = temp;
		}

	}

	// -------------Tests-------------//
	public static void test1() {
		int[] arr1 = { 0, 1, 2, 3, 4, 5 };
		reverse(arr1);
		for (int i : (arr1)) {
			System.out.print(i + " ");
		}
	}

	public static void test2() {
		int[] arr2 = { 0, 1, 2, 3, 4, 5, 6 };
		reverse(arr2);
		for (int i : (arr2)) {
			System.out.print(i + " ");
		}
	}

	public static void test3() {
		int[] arr3 = { 0 };
		reverse(arr3);
		for (int i : (arr3)) {
			System.out.print(i + " ");
		}
	}

	public static void test4() {
		int[] arr4 = {};
		reverse(arr4);
		for (int i : (arr4)) {
			System.out.print(i + " ");
		}
	}

}
