package Assignments_2;

public class assignment1 {

	
	public static void main(String[] args) {
		test();
	}
  /**
   * Takes the array and the last occurring element x,
   * shifting the rest of the elements left. I.e.
   * [1, 4, 7, 9], with x=7 would result in:
   * [1, 4, 9].
   *
   * @param x
   *     the entry to remove from the array
   * @param arr
   *     to remove an entry from
   * @return the updated array, without the last occurrence of x
   */
  public static int[] removeLastOccurrence(int x, int[] arr) {
	   int index = -1;
	   for (int i = arr.length -1; 0 <= i; i--) {
		   if(arr[i] == x) {
			   index = i;
			   break;
		   }
	   }
	   
	   if(index != -1) {
		   int[] copy = new int[arr.length - 1];
		   boolean found = (index == 0) ? true:false;
		   
		   for (int i = 0; i < arr.length -1; i++) {
			   if(found) {
				   copy[i] = arr[i+1];
			   } else {
				   if(i+1 == index) {
					   found = true;
				   }
				   copy[i] = arr[i];
			   }
		   }
		   return copy;
	   }
	   
	   
	   return arr.clone();
	   
  }
  
  public static void test() {
	  int[] arr = {99,1,2,3,4,5,6,2,7,8};
	  int[] a = removeLastOccurrence(99, arr);
	  
	  for (int i : a) {
		System.out.print(i + " ");
	  }
	  
  }

	
}
