package Assignments_6;

public class assignment3 {
	public static void stableSort(String[][] table, int column) {
		String[] current;
		for (int i = 1; i < table.length; i++) {
			current = table[i];
			for (int j = i - 1; 0 <= j; j--) {
				if (current[column].compareTo(table[j][column]) < 0) {
					table[j + 1] = table[j];
					table[j] = current;
				}
			}
		}

	}
}
