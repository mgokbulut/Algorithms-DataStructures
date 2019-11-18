package Week1;

public class assignment4 {
	
	public static void main(String[] args) {
		
		test1();
		
	}
	


	  /**
	   * Calculates the number of occurrences of integers from the range
	   * {0, ..., r} within a given array of integer elements. Returns
	   * the array of counts: a new array of integers of size r + 1, where the
	   * element at index i denotes the number occurrences of elements equal
	   * to i in the given input array (with i in {0, ..., r}).
	   * If the input array is null or of length 0, this will return null.
	   *
	   * @param arr the array of integer elements to be counted.
	   * @param r the integer indicating the last element of the range.
	   * @return a new array containing the number of occurrences of each
	   * integer {0, ..., r} in the input array (index i has the
	   * count of elements equal to i in the input array, with i
	   * in {0, ..., r})
	   */
	
  	  public static int[] count(int[] arr, int r) {
		  if(arr == null || arr.length == 0 ){
		    return null;
		  }
		  
		  int counter;
		  int[] result = new int[r + 1];
		  for (int i = 0; i < r + 1; i++) {
			  counter = 0;
			  for (int a : arr) {
				  if(i == a) {
					  counter++;
				  }
			  }
				  
			  result[i] = counter;
		  }
		  return result;
	  }

  	//-------------Tests-------------//
  	  
  	 public static void test1() {
  		 int[] arr1 = {0,0,0,1,5,1,2,2,3,8,0,3,5,5,2,3};
  		 int[] arr2 = count(arr1,4);
  		 for (int i : arr2) {
			System.out.print(i+ " ");
		}
  	 }


	
}
