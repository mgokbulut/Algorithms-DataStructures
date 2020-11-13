package Tutorial_1;

public class assignment3 {

	/**
	 * Computes the nth number in the Fibonacci sequence.
	 * 
	 * @param n - the index of the number in the Fibonacci sequence.
	 * @return nth number in the Fibonacci sequence
	 */
	public static int fibonacci(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}

	}

}
