package Tutorial_3;

public class assignment6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {101,4,2,6,1,5,4,99,3};
		int[] b = a.clone();
		b[0] = 100;
		System.out.println(a[0]);
		System.out.println(b[0]);
		for (int i : a) {
			System.out.print(i + " ");
		}
		bubbleSort(a);
		System.out.println();
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
	
	public static void bubbleSort(int[] arr) {
		boolean check = true;
		for (int i = 0; i < arr.length; i++) {
			check = true;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					check = false;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(check == true) {
				break;
			}
		}
	}
}
