package Assignments_2;

public class assignment3 {
	
	public static void main(String[] args) {
		test();
	}
	
	static double[][] clone(double[][] a) {
		double[][] b = new double[a.length][];
		
		
		for (int i = 0; i < a.length; i++) {
			b[i]= new double[a[i].length];
			for (int j = 0; j < a.length - 1; j++) {
				b[i][j] = a[i][j];
			}
			int k = 0;
		}
		
		
		return b;
  }
	
	public static void test() {
		double[][] a = {{0,1,2},{3,4,5,6},{7},{8, 8}};
		double[][] b = clone(a);/*
		for (double[] ds : b) {
			for (int i = 0; i < ds.length; i++) {
				System.out.println(ds[i]);
			}
		}
		*/
	}
}
