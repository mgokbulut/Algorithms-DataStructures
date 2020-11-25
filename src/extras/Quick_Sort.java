package extras;

public class Quick_Sort {
	public static void quickSort(int[] elements) {
		if (elements.length < 2) {
			return;
		}
		quickSort(elements, 0, elements.length);
	}

	public static void quickSort(int[] elements, int low, int high) {

		if (high == low) {
			return;
		}

		int i = low - 1;
		int pivot = elements[high - 1];

		for (int j = low; j < high - 1; j++) {
			if (elements[j] < pivot) {
				i++;
				// swap
				int temp = elements[i];
				elements[i] = elements[j];
				elements[j] = temp;
			}
		}

		i++;
		int prev_i = i;

		for (; i < high; i++) {
			int temp = elements[i];
			elements[i] = pivot;
			pivot = temp;
		}

		quickSort(elements, low, prev_i);
		quickSort(elements, prev_i + 1, high);

	}
}
