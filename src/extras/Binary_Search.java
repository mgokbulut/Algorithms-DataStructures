package extras;

public class Binary_Search {
	
	public static void main(String[] args) {
		tests();
		tests_textbook();
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
	
	
	/**
	 * textbook implementation
	 */
	public static int binarySearch_textbook (int[] arr, int element) {
		return binarySearch(arr, element, 0, arr.length / 2, arr.length);
		
	}
	public static int binarySearch_textbook (int[] arr, int element, int left, int right) {
		if(left > right) {
			return -1;
		} else {
			int mid = (left + right) / 2;
			if(element == arr[mid]) {
				return mid;
			} else if (element < arr[mid]) {
				return binarySearch_textbook(arr, element, left, mid -1);
			} else {
				return binarySearch_textbook(arr, element, mid +1, right);
			}
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
	public static void tests_textbook() {
		int[] a = {0,3,5,7,22,43,45};
		System.out.println(binarySearch_textbook(a, 0));
		System.out.println(binarySearch_textbook(a, 3));
		System.out.println(binarySearch_textbook(a, 5));
		System.out.println(binarySearch_textbook(a, 7));
		System.out.println(binarySearch_textbook(a, 22));
		System.out.println(binarySearch_textbook(a, 43));
		System.out.println(binarySearch_textbook(a, 45));
		System.out.println(binarySearch_textbook(a, 4));
		System.out.println(binarySearch_textbook(a, 44));
		System.out.println(binarySearch_textbook(a, -1));
		System.out.println(binarySearch_textbook(a, -32));
		System.out.println(binarySearch_textbook(a, 344));
		System.out.println(binarySearch_textbook(a, 34));
	}
	
}
