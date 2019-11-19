package Assignments_1;

public class assginment1 {
	
	/**
	 * main method includes some examples on how the methods are used and tested
	 * @param args
	 */
	public static void main(String[] args) {
		
		test1();
		test2();
		
	}
	
	/**
	 * the method takes an integer parameter 'n' and finds out if it is prime or not
	 * @param n 
	 * @return returns a boolean to show if it is prime or not (true == prime ^ false == !prime)
	 */
	public static boolean isPrime(int n) {
	    if(n == 0 || n == 1) {
	    	return false;
	    }
	    double border = (Math.sqrt(n));
	    for (int j = 2; j <= border; j++) {
	    	 if(n % j == 0){
	 	        return false;
	 	      }
	    }
	    return true;
	}
	
	/**
	 * 
	 * takes an integer parameter n and finds out how many prime numbers there are from 0 to the number n.
	 * @param n
	 * @return
	 */
	public static int numPrimes(int n) {
		int counter = 0;
		for (; 0 <= n ; n--) {
			if(isPrime(n)) {
				counter++;
				System.out.println(n);
			}
		}
		return counter;
	}
	
	//-------------Tests-------------//
	public static void test1() {
		for (int i = 0; i < 15; i++) {	
			if(isPrime(i)) {
				System.out.print("Prime     - " + i + "\n");
			}else {
				System.out.print("Not Prime - " + i + "\n");
			}
		}
	}
		
	public static void test2() {
		numPrimes(15);
	}

}
