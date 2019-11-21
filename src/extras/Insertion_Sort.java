package extras;

public class Insertion_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {101,4,2,6,1,5,4,99,3};
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
		int current;
		for (int i = 1; i < arr.length; i++) {
			current = arr[i];
			for (int j = i - 1; 0 <= j; j--) {
				if(current < arr[j]) {
					arr[j+1] = arr[j];
					arr[j] = current;
				} 
			}
		}
	}

}
