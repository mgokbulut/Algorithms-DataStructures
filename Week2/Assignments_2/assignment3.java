package Assignments_2;

public class assignment3 {
	
	public static void main(String[] args) {
		test();
	}
	
	/**
	 * clone method for 2 dimentional array
	 * @param a
	 * @return
	 */
	static double[][] clone(double[][] a) {
		double[][] b = new double[a.length][];
		
		
		for (int i = 0; i < a.length; i++) {
			b[i]= new double[a[i].length];
			for (int j = 0; j < b[i].length ; j++) {
				b[i][j] = a[i][j];
			}
		}		
		
		return b;
  }
	
	public static void test() {
		double[][] a = {{0,1,2},{3,4,5,6},{7},{8, 8}};
		double[][] b = clone(a);
		
		
		for (double[] ds : b) {
			for (int i = 0; i < ds.length; i++) {
				System.out.print(ds[i] + " ");
			}
			System.out.println();
		}
		
	}
}
