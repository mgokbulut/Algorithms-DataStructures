package Assignments_5;

public class assignment1 {
	/**
	 * @param elements Array of integers to be sorted.
	 */
	public static void selectionSort(int[] elements) {
		int lowest;
		int temp = 0;
		for (int i = 0; i < elements.length; i++) {
			lowest = i;
			for (int j = i; j < elements.length; j++) {
				if (elements[j] < elements[lowest]) {
					lowest = j;
				}
			}
			temp = elements[i];
			elements[i] = elements[lowest];
			elements[lowest] = temp;
		}
	}
}
