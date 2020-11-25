package extras;

public class Insertion_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 101, 4, 2, 6, 1, 5, 4, 99, 3 };
		int[] b = a.clone();
		b[0] = 100;
		System.out.println(a[0]);
		System.out.println(b[0]);
		for (int i : a) {
			System.out.print(i + " ");
		}
		InsertionSort_myVersion(a);
		System.out.println();
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static void InsertionSort_myVersion(int arr[]) {

	}

}
