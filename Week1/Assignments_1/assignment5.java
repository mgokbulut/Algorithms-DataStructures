package Assignments_1;

public class assignment5 {

	/**
	 * Implement a method multiply that calculates and returns the multiplication
	 * num1 * num2 of the two given integers num1 and num2.
	 * 
	 * Your solution should:
	 * 
	 * Be recursive, that is, calculate the result using recursion; Not use the
	 * multiplication operator. Instead, you can make us of the addition +,
	 * subtraction -, equality ==, and inequality < operators.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
	}

	/**
	 * recursive multiplication of 2 numbers without the multiplication operator
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int multiply(int num1, int num2) {
		if (num1 == 0 || num2 == 0) {
			return 0;
		}
		if (num2 <= -1) {
			return multiply(-num1, -num2);
		} else if (num2 > 1) {
			return num1 + multiply(num1, num2 - 1);
		} else {
			return num1;
		}
	}
	// -------------Tests-------------//

	public static void test1() {
		System.out.println(multiply(5, 4));
	}

	public static void test2() {
		System.out.println(multiply(5, -4));
	}

	public static void test3() {
		System.out.println(multiply(-5, 4));
	}

	public static void test4() {
		System.out.println(multiply(-5, -4));
	}

	public static void test5() {
		System.out.println(multiply(4, 0));
	}

	public static void test6() {
		System.out.println(multiply(0, 4));
	}

	public static void test7() {
		System.out.println(multiply(0, 0));
	}

	public static void test8() {
		System.out.println(multiply(-1, -1));
	}

}
