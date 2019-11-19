package Tutorial_1;

public class Assignment1 {
	public static void main(String[] args) {
		test();
	}
	  /**
	   * Returns the sum of all elements in the array up to (and including) the `n`th element
	   *
	   * @param arr the array of integers that needs to be summed
	   * @param n the index of the last item to consider
	   */
	  public static int sumElementsUpTo(int[] arr, int n) {
	    int sum = 0;
	    for(int i = 0 ; i <= n; i++) {
	      sum += arr[i];
	    }
	    return sum;
	  }
	  
	  public static void test() {
		  int[] arr = {0,1,2,3,4,5};
		  System.out.println(sumElementsUpTo(arr, 4));
	  }
}
