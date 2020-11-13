package Tutorial_1;

public class assignment2 {
	/**
	 * Returns the sum of all elements in the array up to (and including) the `n`th
	 * element
	 *
	 * @param arr the array of integers that needs to be summed
	 * @param n   the index of the last item to consider
	 */
	public static int sumElementsUpTo(int[] arr, int n) {
		if (n == 0) {
			return arr[0];
		} else {
			return arr[n] + sumElementsUpTo(arr, n - 1);
		}
	}
}
