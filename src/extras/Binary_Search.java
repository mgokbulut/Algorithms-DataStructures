package extras;

public class Binary_Search {
	
	public static void main(String[] args) {
		tests();
	}
	
	public static int binarySearch (int[] arr, int element) {
		return binarySearch(arr, element, 0, arr.length / 2, arr.length);
		
	}
	public static int binarySearch (int[] arr, int element, int left, int mid, int right) {
		
		if(element == arr[mid]) {
			return mid;
		} else if(left == mid || right == mid) {
			return -1;
		} else if(element > arr[mid]) {
			left = mid;
			mid = ((right + left) / 2);
			return binarySearch(arr, element, left, mid, right);
		} else if(element < arr[mid]) {
			right = mid;
			mid = (right + left) / 2;
			return binarySearch(arr, element, left, mid, right);
		} else {
			// error code, index -1 indicates that the element is not in the set.
			return -1;
		}
	}
	
	public static void tests() {
		int[] a = {0,3,5,7,22,43,45};
		System.out.println(binarySearch(a, 0));
		System.out.println(binarySearch(a, 3));
		System.out.println(binarySearch(a, 5));
		System.out.println(binarySearch(a, 7));
		System.out.println(binarySearch(a, 22));
		System.out.println(binarySearch(a, 43));
		System.out.println(binarySearch(a, 45));
		System.out.println(binarySearch(a, 4));
		System.out.println(binarySearch(a, 44));
		System.out.println(binarySearch(a, -1));
		System.out.println(binarySearch(a, -32));
		System.out.println(binarySearch(a, 344));
		System.out.println(binarySearch(a, 34));
	}
	
}
