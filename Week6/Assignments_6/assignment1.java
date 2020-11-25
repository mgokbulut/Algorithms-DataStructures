package Assignments_6;

import java.util.Random;

public class assignment1 {

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5 };

		int[] arr = { 5, 2, 8, 4, 7, -3, 11, 7, 3, 82, 8 };
		int[] arr1 = { 2, 5, 7, 8, 3 };
		int[] arr2 = { 1, 4, 6, 7, 9 };
		int[] arr3 = { 1, 2, 3, 8, 4, 5 };

		quickSort(arr);
		quickSort(arr1);
		quickSort(arr2);
		quickSort(arr3);

		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
		for (int i : arr1) {
			System.out.print(i + " ");
		}

		System.out.println();
		for (int i : arr2) {
			System.out.print(i + " ");
		}

		System.out.println();
		for (int i : arr3) {
			System.out.print(i + " ");
		}

		int[] a0 = new int[0];
		int[] a1 = {};
		int[] a2 = { 5, 4, 8, 12, 1, 9, 3, 11, 6 };
		System.out.println("line");
		quickSort(a0);
		printArray(a0);
		quickSort(a1);
		printArray(a1);
		quickSort(a2);
		printArray(a2);

//		int[] pasaArray1 = generateArray(4);
//		int[] pasaArray1 = { -78, -70, -62, -51, 33, 97, 53, 57, 90, 65 };

//		int[] pasaArray1 = { -72, -27, -23, -1, 1, 2, 57, 71, 87, 49 };
//		int[] pasaArray1 = { 21, 86, 64, 63, -49, -32, -82, -1, -5, -63 };
		int[] pasaArray1 = { -22, -32, 42, -62 };
		printArray(pasaArray1);
		quickSort(pasaArray1);
		printArray(pasaArray1);
		System.out.println(isSorted(pasaArray1));
//		-1910359752 -1393530768 -1781478540 -1258461975 -1190734370 -1076146834 -10404521 214137055 946675794 1454714098 

	}

	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}

		return true;
	}

	public static int[] generateArray(int length) {
		Random rd = new Random();
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = rd.nextInt(200) - 100;
		}
		return array;
	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void subpart(int[] elements) {

		int i = -1;
		int pivot = elements[elements.length - 1];
		for (int j = 0; j < elements.length - 1; j++) {
			if (elements[j] < pivot) {
				i++;
				// swap
				int temp = elements[i];
				elements[i] = elements[j];
				elements[j] = temp;
			}
		}
		i++;
		for (; i < elements.length; i++) {
			int temp = elements[i];
			elements[i] = pivot;
			pivot = temp;
		}

	}

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

//class Solution {
//	/**
//	 * @param elements Array of integers to be sorted.
//	 */
//	public static void quickSort(int[] arr) {
//		quicksort(arr, 0, arr.length - 1);
//	}
//
//	public static void quicksort(int[] arr, int low, int high) {
//		int lowPointer = low;
//		int highPointer = high;
//		int middle = (high + low) / 2;
//		int pivot = arr[middle];
//
//		while (lowPointer <= highPointer) {
//			while (arr[lowPointer] < pivot) {
//				lowPointer++;
//			}
//			while (arr[highPointer] > pivot) {
//				highPointer--;
//			}
//			// swap the highest from left and lowest from right half
//			if (lowPointer <= highPointer) {
//				int temp = arr[lowPointer];
//				arr[lowPointer] = arr[highPointer];
//				arr[highPointer] = temp;
//				highPointer--;
//				lowPointer++;
//			}
//		}
//
//		// lower half
//		if (low < highPointer) {
//			quicksort(arr, low, highPointer);
//		}
//		// higher half
//		if (high > lowPointer) {
//			quicksort(arr, lowPointer, high);
//		}
//
//	}
//}